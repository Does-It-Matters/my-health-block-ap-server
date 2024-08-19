package com.example.myhealthblock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <b> 역할: 전역적인 예외를 처리하는 클래스 </b>
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * <b> 역할: 커스텀 예외 처리하는 메소드 </b>
     *
     * @param e 발생한 예외
     * @return 잘못된 요청 응답
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ResponseError> handleInvalidRequestException(CustomException e) {
        ResponseError response = new ResponseError("Custom exception: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * <b> 역할: 회원가입 시 사용자가 이미 존재하는 예외를 처리하는 메소드 </b>
     *
     * @param e 발생한 예외
     * @return 잘못된 요청 응답
     */
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ResponseError> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        ResponseError response = new ResponseError("conflict: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }


    /**
     * <b> 역할: 모든 예외를 처리하여 공통된 오류 응답을 반환하는 메소드 </b>
     *
     * @param e 발생한 예외
     * @return 공통 오류 응답
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handleException(Exception e) {
        ResponseError response = new ResponseError("An unexpected error occurred: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
