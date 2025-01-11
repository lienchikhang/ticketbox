package com.ticket.ticket_backend.exception;

import com.ticket.ticket_backend.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppException extends RuntimeException {

    ErrorCode errorCode;

//    public AppException(ErrorCode errorCode) {
//        code = errorCode.getCode();
//        statusCode = errorCode.getStatusCode();
//        msg = errorCode.getMsg();
//    }
}
