package com.yasu.ccsapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class AuthTestController {

    @GetMapping("check")
    public ResponseEntity<Object> check() {
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
}
