package com.yasu.ccsapi.controller;

import com.yasu.ccsapi.DTO.ApiListMapDto;
import com.yasu.ccsapi.DTO.ErrorDto;
import com.yasu.ccsapi.ErrorCords;
import com.yasu.ccsapi.Service.AuthService;
import com.yasu.ccsapi.Service.MapApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/map")
public class MapApiController {
    @Autowired
    MapApiService mapApiService;
    @Autowired
    AuthService authService;

    @GetMapping
    public List<?> mapList(@RequestParam(required = false) String key, @RequestParam(required = false) Integer studNum) {
        if (key == null)
            return authService.makeErrorMsg(ErrorCords.KEY_NOT_FOUND);
        else if (studNum == null)
            return authService.makeErrorMsg(ErrorCords.STUD_NUM_NOT_FOUND);

        String decryptedKey = authService.decrypt(key, studNum);
        if(decryptedKey == null)
            return authService.makeErrorMsg(ErrorCords.API_DECRYPT_ERROR);

        String res = authService.auth(decryptedKey, studNum);

        switch (res) {
            case "OK" -> {
                return mapApiService.getMapList();
            }
            case "ERR_USER_NOT_FOUND" -> {
                return authService.makeErrorMsg(ErrorCords.USER_NOT_FOUND);
            }
            case "ERR_KEY_NOT_MATCH" -> {
                return authService.makeErrorMsg(ErrorCords.USER_NOT_MATCH);
            }
            case "ERR_API_NOT_FOUND" -> {
                return authService.makeErrorMsg(ErrorCords.API_NOT_MATCH);
            }
            default -> {
                return authService.makeErrorMsg(ErrorCords.SERVER_ERROR);
            }
        }
    }
}
