package com.br.srv.saudeconnect.domain.exception;

import com.br.srv.saudeconnect.enums.ExceptionEnum;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final ExceptionEnum exceptionEnum;

    public CustomException(final ExceptionEnum exceptionEnum) {
        super();
        this.exceptionEnum = exceptionEnum;
    }
}
