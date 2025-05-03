package com.vti.helloworld.exception;

import lombok.Data;

@Data
public class LogicCustomException extends RuntimeException {
    private int code;
    private String message;
}
