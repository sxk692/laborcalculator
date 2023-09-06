package com.sherwin.exercise.laborcalculator.rest.resources.v1;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class LaborResponse {
    @Positive
    private int id;
    @Positive
    private double price;

}
