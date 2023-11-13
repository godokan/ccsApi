package com.yasu.ccsapi.controller;

import com.yasu.ccsapi.Domain.Repository.ApiUserRepository;
import com.yasu.ccsapi.Service.UserService;
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
    private UserService userService;

    @GetMapping("/issue")
    public String issueKey(@RequestParam String id, @RequestParam Integer studNum, @RequestParam String apiName) throws Exception {
        return userService.issue(id, studNum, apiName);
    }

    @GetMapping("/findUser")
    public String isSigned(@RequestParam Integer studNum) {
        if (userService.isSigned(studNum))
            return "OK";
        return "NF"; // Not Found
    }

    @GetMapping("/signup")
    public String signup(@RequestParam Integer studNum, @RequestParam String id) {
        System.out.println(studNum+"/"+id);
        if (userService.isSigned(studNum)) return "ERR"; // 중복 가입 방지

        if (userService.signup(studNum, id))
            return "OK";
        else return "ERR";
    }


}
