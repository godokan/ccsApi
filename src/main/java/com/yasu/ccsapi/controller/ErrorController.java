package com.yasu.ccsapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {
    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String errorHtml() {
        return "본 서버는 API 전용 서버로 text/html요청을 지원하지 않습니다";
    }

    @GetMapping
    public HttpStatus error() {
        return HttpStatus.BAD_REQUEST;
    }
}
