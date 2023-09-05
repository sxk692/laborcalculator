package com.sherwin.exercise.laborcalculator.rest.resources.v1;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class LaborCalculatorFrontEndRequest {
    @Positive
//    @Pattern not currently working
//    @Pattern(regexp = "^[+]?([.]\\d+|\\d+([.]\\d+)?)$")
//    message = "Please input a valid positive number")
    private double length;
    @Positive
    private double width;
    @Positive
    private double pricePerSqft;
}
