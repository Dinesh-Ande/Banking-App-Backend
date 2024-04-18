package com.java.Banking.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoAccountFoundException extends RuntimeException{
    public NoAccountFoundException(String message){
        super(message);
    }
}
