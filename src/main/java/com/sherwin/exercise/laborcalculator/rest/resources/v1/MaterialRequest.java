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
public class MaterialRequest {
    @Positive
    private double length;
    @Positive
    private double width;
    @Positive
    private double sqftPerGallon;
}
