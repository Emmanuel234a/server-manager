package com.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AdminNotFound extends RuntimeException{
//    define a constructor to pass the message

    public AdminNotFound(String message) {
        super(message);
    }
}
