package com.br.srv.saudeconnect.entrypoint.rest.interceptor;

import com.br.srv.saudeconnect.domain.exception.CustomException;
import com.br.srv.saudeconnect.entrypoint.rest.commons.dto.ErrorDTO;
import com.br.srv.saudeconnect.entrypoint.rest.commons.dto.ExceptionResponseDTO;
import com.br.srv.saudeconnect.enums.ExceptionEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ResponseEntity<ExceptionResponseDTO> handleMethodArgumentNotValidException(
            final MethodArgumentNotValidException methodArgumentNotValidException) {

        final List<String> errors = new ArrayList<>();

        for (final FieldError error :
                methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        for (final ObjectError error :
                methodArgumentNotValidException.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        return new ResponseEntity<>(
                ExceptionResponseDTO.builder()
                        .dateTime(LocalDateTime.now())
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .statusMessage(errors.toString())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponseDTO> handleCustomException(final CustomException exception) {
        final ExceptionEnum exceptionEnum = exception.getExceptionEnum();
        final HttpStatus status = exceptionEnum.getStatus();

        final ErrorDTO error = ErrorDTO.builder()
                .code(exceptionEnum.getCode())
                .message(exceptionEnum.getMessage())
                .build();

        final ExceptionResponseDTO exceptionResponse = ExceptionResponseDTO.builder()
                .dateTime(LocalDateTime.now())
                .statusCode(status.value())
                .statusMessage(status.getReasonPhrase())
                .error(error)
                .build();

        return ResponseEntity.status(status).body(exceptionResponse);
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ResponseEntity<ExceptionResponseDTO> handleNotFound(final Exception exception) {

        final ErrorDTO error =
                ErrorDTO.builder().message(exception.getMessage()).build();

        return new ResponseEntity<>(
                ExceptionResponseDTO.builder()
                        .dateTime(LocalDateTime.now())
                        .statusCode(HttpStatus.NOT_FOUND.value())
                        .statusMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                        .error(error)
                        .build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ResponseEntity<ExceptionResponseDTO> handleException(final Exception exception) {

        return new ResponseEntity<>(
                ExceptionResponseDTO.builder()
                        .dateTime(LocalDateTime.now())
                        .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .statusMessage(exception.getMessage())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
