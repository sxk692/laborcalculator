package com.sherwin.exercise.laborcalculator.rest;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculator;
import com.sherwin.exercise.laborcalculator.domain.service.LaborCalculatorService;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.LaborCalculatorMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaborCalculatorController {

    @Autowired
    LaborCalculatorMapper laborCalculatorMapper;
    @Autowired
    LaborCalculatorService laborCalculatorService;
    @PostMapping("labor/price")
    public LaborCalculatorResponse getLaborCalculationPerSqft(@RequestBody LaborCalculatorRequest frontEndRequest){
        // Taking in body object received from front-end and putting into a DTO, this seems redundant, however.
       return laborCalculatorService.frontendRequestToCalculatedLabor(frontEndRequest);
    }
}
