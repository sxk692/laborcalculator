package com.sherwin.exercise.laborcalculator.exception.handler;

import com.sherwin.exercise.laborcalculator.exception.ErrorDetail;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class MaterialExceptionHandler {
    @ExceptionHandler
    private ResponseEntity<ErrorDetail> handleConstraintViolation(ConstraintViolationException ex, WebRequest request){

        ErrorDetail errorDetail = new ErrorDetail
                ( HttpStatus.BAD_REQUEST.value(),
                        new Date(),
                        "Received negative for values or missing constraints",
                        request.getDescription(true)
                );

        return new ResponseEntity<ErrorDetail>(errorDetail, HttpStatus.BAD_REQUEST);
    }
}
