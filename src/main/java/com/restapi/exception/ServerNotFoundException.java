package com.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ServerNotFoundException extends RuntimeException{
//     create a constructor to pass the message


    public ServerNotFoundException(String message) {
        super(message);
    }
}
