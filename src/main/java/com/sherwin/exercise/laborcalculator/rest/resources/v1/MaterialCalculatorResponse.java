package com.sherwin.exercise.laborcalculator.rest.resources.v1;

import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MaterialCalculatorResponse {
    public int id;
    public double gallonsRequired;
}
