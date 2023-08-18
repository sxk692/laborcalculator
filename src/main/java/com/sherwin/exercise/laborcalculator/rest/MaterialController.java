package com.sherwin.exercise.laborcalculator.rest;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculator;
import com.sherwin.exercise.laborcalculator.domain.service.LaborCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialController {

    @Autowired
    LaborCalculatorService laborCalculatorService;
    @PostMapping("labor/gallons")
    public double getGallonsRequiredPerSqft(@RequestBody LaborCalculator bodyValues){
        // Is there where jackson could come into play, do destructure teh json objet to use my other polymorphed
        // method in LaborCalculatorService
        return laborCalculatorService.calculateGallonsPerSqft(bodyValues);
    }
}
