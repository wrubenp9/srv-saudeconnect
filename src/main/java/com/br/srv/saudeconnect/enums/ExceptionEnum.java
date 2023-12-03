package com.br.srv.saudeconnect.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {
    USER_CREATE_INVALID(1050, "Account create error", HttpStatus.UNPROCESSABLE_ENTITY),
    USER_UPDATE_INVALID(1051, "Account update error", HttpStatus.UNPROCESSABLE_ENTITY),
    USER_NOT_FOUND(1052, "Account doesn't exist", HttpStatus.UNPROCESSABLE_ENTITY),
    USER_EXIST(1053, "Account already exists", HttpStatus.UNPROCESSABLE_ENTITY),
    USER_EMAIL_EXIST(1054, "Account with email already registered", HttpStatus.UNPROCESSABLE_ENTITY),
    AUTHENTICATION_ERROR(1100, "Authentication error", HttpStatus.BAD_REQUEST),
    AUTHENTICATION_ERROR_GENERATE_TOKEN(1101, "Error generating token", HttpStatus.BAD_REQUEST),
    AUTHENTICATION_MISSING_TOKEN(1102, "Missing token", HttpStatus.BAD_REQUEST),
    AUTHENTICATION_INVALID_TOKEN(1103, "invalid or expired token", HttpStatus.BAD_REQUEST),
    ENTITY_NOT_FOUND(1200, "Entity not found", HttpStatus.UNPROCESSABLE_ENTITY),
    ENTITY_EXIST(1201, "Entity already exists", HttpStatus.UNPROCESSABLE_ENTITY),
    ENTITY_NOT_CREATE(1202, "Could not create entity", HttpStatus.UNPROCESSABLE_ENTITY);

    private final int code;
    private final String message;
    private final HttpStatus status;
}
