package com.sherwin.exercise.laborcalculator.infrastructure;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class LaborCalculation {
    private double length;
    private double width;
    private double pricePerSqft;
    private double price;
}
