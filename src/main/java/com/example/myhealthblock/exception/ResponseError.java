package com.example.myhealthblock.exception;

/**
 * <b> 역할: 에러 응답 클래스 </b>
 */
public class ResponseError {
    private String error;

    public ResponseError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
