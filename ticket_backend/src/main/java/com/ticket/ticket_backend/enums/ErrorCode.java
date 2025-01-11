package com.ticket.ticket_backend.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {

    ROLE_NOT_FOUND(1200, 404, "Role not found"),
    PERMISSION_NOT_FOUND(1201, 404, "Permission not found")
    ;

    int code;
    int statusCode;
    String msg;

    ErrorCode(int code, int statusCode, String msg) {
        this.code = code;
        this.statusCode = statusCode;
        this.msg = msg;
    }


}
