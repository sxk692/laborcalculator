package com.sherwin.exercise.laborcalculator.rest;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculated;
import com.sherwin.exercise.laborcalculator.domain.service.LaborCalculatorService;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.LaborCalculatorMapper;
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
    private LaborCalculatorService laborCalculatorService;
    @Autowired
    private LaborCalculatorMapper laborCalculatorMapper;
    @PostMapping("labor/price")
    /* Don't actually need the @Valid annotation since we have the ConstraintViolationException being handled in the
     Exception class, see MaterialCalculatorController, we are not using @Valid in the method, but we get same error message
     As expected thnanks to the exception class built that is handling all ConstraintViolationExceptions
    */
    private LaborCalculatorResponse getLaborCalculationPerSqft(@Valid @RequestBody LaborCalculatorRequest frontEndRequest){

        // Calculated object returned
       LaborCalculated laborCalculated = laborCalculatorService.calculateLabor(frontEndRequest);

       // Mapping calculated object to response DTO
       return laborCalculatorMapper.convertLaborCalculatedtoLaborCalculatorResponse(laborCalculated);

    }
}
