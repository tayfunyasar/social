package com.social.app.config.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ApiException extends RuntimeException {

    private final ErrorCode errorCode;

    @Override
    public String getMessage() {
        return errorCode.getMessage();
    }

    public HttpStatus getHttpStatus() {
        return errorCode.getHttpStatus();
    }
}
