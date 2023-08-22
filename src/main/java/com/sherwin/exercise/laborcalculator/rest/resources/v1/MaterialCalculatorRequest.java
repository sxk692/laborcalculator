package com.sherwin.exercise.laborcalculator.rest.resources.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MaterialCalculatorRequest {
    public double length;
    public double width;
    public double sqftPerGallon;
}
