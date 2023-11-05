package com.yasu.ccsapi.controller;

import com.yasu.ccsapi.security.CryptoManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class AuthTestController {

    @GetMapping
    public ResponseEntity<Object> check(@RequestParam String key) throws Exception {
        if (key == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(true);
        CryptoManager crypto = new CryptoManager();
        String text = crypto.decrypt(key, "202155012");
        return ResponseEntity.status(HttpStatus.OK).body(text);
    }

    @GetMapping("/make")
    public String makeit() throws Exception {
        String key = "kookookoo/mapApi";
        CryptoManager crypto = new CryptoManager();
        key = crypto.encrypt(key, "202155012");


        return key;
    }
}
