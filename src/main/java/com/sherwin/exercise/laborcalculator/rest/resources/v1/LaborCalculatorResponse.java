package com.sherwin.exercise.laborcalculator.rest.resources.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class LaborCalculatorResponse {
    public int id;
    public double price;

}
