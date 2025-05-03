package com.vti.helloworld.modal;

import lombok.Data;

import java.util.Date;

@Data
public class CustomException {
    private Date timestamp;
    private int status;
    private String message;
    private String path;
}
