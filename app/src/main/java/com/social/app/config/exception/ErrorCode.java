package com.social.app.config.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_EMAIL_OR_PASSWORD(BAD_REQUEST, "BAD_REQUEST"),
    INVALID_TOKEN(UNAUTHORIZED, "UNAUTHORIZED"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
