package com.test.migration.error;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    private static final String UNKNOWN_ERROR_MSG = "Erro desconhecido";
    private static final String MALFORMED_JSON_MSG = "Corpo da requisição mal estruturado";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleResourceException(MethodArgumentNotValidException exception) {

        ErrorDetails errorDetails = ErrorDetails.newBuilder()
            .status(HttpStatus.BAD_REQUEST.value())
            .errors(exception
                .getBindingResult()
                .getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList())
            );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleResourceException(ResponseStatusException exception) {

        ErrorDetails errorDetails = ErrorDetails.newBuilder()
            .status(exception.getStatus().value())
            .errors(List.of(exception.getReason() == null? UNKNOWN_ERROR_MSG : exception.getReason()));

        return ResponseEntity.status(exception.getStatus()).body(errorDetails);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleResourceException(HttpMessageNotReadableException exception) {

        ErrorDetails errorDetails = ErrorDetails.newBuilder()
            .status(HttpStatus.EXPECTATION_FAILED.value())
            .errors(List.of(MALFORMED_JSON_MSG));

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(errorDetails);
    }
}