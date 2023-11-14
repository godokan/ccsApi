package com.yasu.ccsapi.DTO;

import com.yasu.ccsapi.ErrorCords;
import lombok.Builder;
import lombok.Data;

@Data
public class ErrorDto {
    private ErrorCords errorCode;
    private String message;
    private final String result = "ERR";

    @Builder
    public ErrorDto(ErrorCords errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}
