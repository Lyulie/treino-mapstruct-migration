package com.test.migration.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class AppException extends Exception {

    private final List<String> reasons;
    private final HttpStatus status;

    public AppException(List<String> reasons, HttpStatus status) {
        super("Requisição inválida");
        this.status = status;
        this.reasons = reasons;
    }

    public List<String> getReasons() {
        return reasons;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
