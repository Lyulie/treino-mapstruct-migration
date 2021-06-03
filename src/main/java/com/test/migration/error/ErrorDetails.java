package com.test.migration.error;

import java.util.List;

public class ErrorDetails {

    private Integer status;
    private List<String> errors;

    public static ErrorDetails newBuilder(){
        return new ErrorDetails();
    }

    public ErrorDetails status(Integer status){
        this.status = status;
        return this;
    }

    public ErrorDetails errors(List<String> errors){
        this.errors = errors;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public List<String> getErrors() {
        return errors;
    }
}