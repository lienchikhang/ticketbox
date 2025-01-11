package com.ticket.ticket_backend.exception;

import com.ticket.ticket_backend.dto.common.ApiRes;
import com.ticket.ticket_backend.enums.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class HandlingException {

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ApiRes> handlingAppException(AppException e) {

        ErrorCode errorCode = e.getErrorCode();

        ApiRes apiResponse = ApiRes
                .builder()
                .statusCode(errorCode.getStatusCode())
                .msg(errorCode.getMsg())
                .build();

        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);

    };

}
