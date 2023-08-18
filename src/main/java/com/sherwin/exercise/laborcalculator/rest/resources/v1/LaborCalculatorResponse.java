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

    //Not sure why, but removing above annotations and uncommenting below fixes the issue that was not present prior
    // to adding mappers and restructuring folders.
//    public LaborCalculatorResponse(int id, double price){
//        this.id = id;
//        this.price = price;
//    }
}
