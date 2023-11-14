package com.yasu.ccsapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCords {

    KEY_NOT_FOUND(HttpStatus.BAD_REQUEST, "MISSING KEY"),
    STUD_NUM_NOT_FOUND(HttpStatus.BAD_REQUEST,"MISSING STUD_NUM"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "CANNOT FIND USER"),
    USER_NOT_MATCH(HttpStatus.FORBIDDEN, "USER NOT MATCHES WITH KEY"),
    INVALID_PERMISSION(HttpStatus.UNAUTHORIZED, "PERMISSION DENIED"),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL SERVER ERROR"),
    API_NOT_MATCH(HttpStatus.FORBIDDEN, "CANNOT AUTH THE KEY WITH STUD_NUM OR API"),
    API_DECRYPT_ERROR(HttpStatus.UNPROCESSABLE_ENTITY, "UNPROCESSABLE KEY");

    private final HttpStatus status;
    private final String message;
}
