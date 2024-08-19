package com.example.myhealthblock.exception;

/**
 * <b> 역할: 커스텀 예외 </b>
 */
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}