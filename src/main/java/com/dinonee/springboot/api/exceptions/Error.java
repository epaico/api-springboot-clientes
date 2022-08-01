package com.dinonee.springboot.api.exceptions;

import lombok.Data;

@Data
public class Error {
    private String message;
    private int status;
    private Long timestamp;


}
