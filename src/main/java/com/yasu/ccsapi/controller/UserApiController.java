package com.yasu.ccsapi.controller;

import com.yasu.ccsapi.security.CryptoManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @GetMapping("/issue")
    public String issueKey(@RequestParam String id, @RequestParam String stdNum, @RequestParam String apiName) throws Exception {
        String issued;
        CryptoManager manager = new CryptoManager();
        issued = manager.encrypt(id+"/"+apiName,stdNum);
        System.out.println(issued);
        System.out.println(manager.decrypt("o1JHR+pePxQfNeiDOQgUVw==:qbk+s40imz9GSDo81ZQXdQ==",stdNum));
        return issued;
    }
}
