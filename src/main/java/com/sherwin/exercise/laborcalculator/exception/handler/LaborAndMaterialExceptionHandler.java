package com.sherwin.exercise.laborcalculator.exception.handler;

import com.sherwin.exercise.laborcalculator.exception.ErrorDetail;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class LaborAndMaterialExceptionHandler extends ResponseEntityExceptionHandler {


    /*
    We already get a 500 error, since we have established @Min annotations on the objects
    which is why in Material controller, I didn't include @valid in the params to test if it still
    works and it does (bc of @Min, @NotNull, etc annotations in the entity/domain objects).
    This @ExceptionHandler provides a more custom solution for that same ConstraintViolationException.
     */
    @ExceptionHandler
    private ResponseEntity<ErrorDetail> handleConstraintViolation(ConstraintViolationException ex, WebRequest request){

        ErrorDetail errorDetail = new ErrorDetail
                ( HttpStatus.NOT_ACCEPTABLE.value(),
                        new Date(),
                        "Received negative number or missing constraints",
                        request.getDescription(true)
        );

        return new ResponseEntity<ErrorDetail>(errorDetail, HttpStatus.NOT_ACCEPTABLE);
    }
}
