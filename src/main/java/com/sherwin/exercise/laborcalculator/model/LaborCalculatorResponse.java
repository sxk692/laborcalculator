package com.sherwin.exercise.laborcalculator.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class LaborCalculatorResponse {
    public int id;
    public double price;
}
