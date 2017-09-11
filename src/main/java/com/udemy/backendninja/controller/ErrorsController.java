package com.udemy.backendninja.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsController {

    public static final String SERVER_INTERNAL_ERROR_VIEW = "error/500";

    @ExceptionHandler(Exception.class)
    public String showInternalServerError() {
        return SERVER_INTERNAL_ERROR_VIEW;
    }
}
