package com.example.demo.Utils.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataNotValidException.class)
    public ErrorDisplay handleValidationExceptions(DataNotValidException ex) {
        return new ErrorDisplay(ex.getMessage(),HttpStatus.BAD_REQUEST.value(),new Date());
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DataNotFoundException.class)
    public ErrorDisplay handleNotFoundExceptions(DataNotFoundException ex) {
        return new ErrorDisplay(ex.getMessage(),HttpStatus.NOT_FOUND.value(),new Date());
    }
}