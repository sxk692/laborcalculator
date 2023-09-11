package com.sherwin.exercise.laborcalculator.exception.handler;

import com.sherwin.exercise.laborcalculator.exception.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class LaborAndMaterialExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private Map<String,String> handleConstraintViolation(MethodArgumentNotValidException ex, WebRequest request){
        Map<String,String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<ErrorDetail> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) throws IOException {
        ErrorDetail error = new ErrorDetail(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                "Please use positive numbers only",
                request.getDescription(false)
        );
        return new ResponseEntity<ErrorDetail>(error, HttpStatus.BAD_REQUEST);
    }
}
