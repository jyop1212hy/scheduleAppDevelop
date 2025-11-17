package com.scheduleappdevelop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //전역 예외 처리기
public class GlobalExceptionHandler {

    // MovieNotFoundException 커스텀 에러 핸들링
    //비밀번호 오류 (401)
    @ExceptionHandler(ServerException.class)
    public ResponseEntity<String> handleServerException(ServerException ex) {
        return ResponseEntity
                .status(ex.getStatus())  // 서버익셉션이 들고온 상태 코드
                .body(ex.getMessage()); // 서버익셉션이 들고온 메시지
    }

    // NullPointerException 같은 예상치 못한 오류 → 500
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointer(NullPointerException e) {
        return ResponseEntity
                .internalServerError()
                .body("서버 내부 오류가 발생했습니다.");
    }

    // 기타 모든 Exception 처리 (옵션)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneral(Exception ex) {
        return ResponseEntity
                .internalServerError()
                .body("예상치 못한 오류가 발생했습니다.");
    }
}