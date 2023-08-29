package com.sherwin.exercise.laborcalculator.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {
    private int statusCode;
    private Date timeStamp;
    private String message;
    private String description;
}
