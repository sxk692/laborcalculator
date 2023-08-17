package com.sherwin.exercise.laborcalculator.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class LaborCalculator {

    public double length;
    public double width;
    public double pricePerSqft;
    public double sqftPerGallon;
}
