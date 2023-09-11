package com.sherwin.exercise.laborcalculator.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class MaterialCalculation {
    private double length;
    private double width;
    private double sqftPerGallon;
    private double gallonsRequired;

}
