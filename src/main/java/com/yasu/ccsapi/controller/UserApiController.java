package com.yasu.ccsapi.controller;

import com.yasu.ccsapi.DTO.ApiUserDto;
import com.yasu.ccsapi.Domain.Repository.ApiUserRepository;
import com.yasu.ccsapi.Service.UserService;
import com.yasu.ccsapi.security.CryptoManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    private ApiUserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/issue")
    public String issueKey(@RequestParam String id, @RequestParam Integer stdNum, @RequestParam String apiName) throws Exception {
        return userService.issue(id, stdNum, apiName);
    }


}
