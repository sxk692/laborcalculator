package com.sherwin.exercise.laborcalculator.rest;

import com.sherwin.exercise.laborcalculator.domain.service.LaborCalculatorService;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaborCalculatorController {

    @Autowired
    LaborCalculatorService laborCalculatorService;
    @PostMapping("labor/price")
    /* Don't actually need the @Valid annotation since we have the ConstraintViolationException being handled in the
     Exception class, see MaterialCalculatorController, we are not using @Valid in the method, but we get same error message
     As expected thnanks to the exception class built that is handling all ConstraintViolationExceptions
    */
    public LaborCalculatorResponse getLaborCalculationPerSqft(@Valid @RequestBody LaborCalculatorRequest frontEndRequest){
        // Taking in body object received from front-end and putting into a DTO.
       return laborCalculatorService.frontendRequestToCalculatedLabor(frontEndRequest);
    }
}
