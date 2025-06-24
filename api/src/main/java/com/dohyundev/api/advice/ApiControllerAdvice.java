package com.dohyundev.api.advice;

import com.dohyundev.common.CommonError;
import com.dohyundev.common.exception.BusinessException;
import com.dohyundev.common.exception.ForbiddenException;
import com.dohyundev.common.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {
    private static final CommonError SERVER_ERROR = new CommonError(
            HttpStatus.INTERNAL_SERVER_ERROR.name(),
            "서버에 문제가 생겼습니다. 잠시 후 다시 시도 해주세요."
    );

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleSeverException(Exception ex) {
        return ResponseEntity.internalServerError()
                .body(SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusinessException(final BusinessException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(final NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getError());
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<?> handleForbiddenException(final ForbiddenException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getError());
    }
}
