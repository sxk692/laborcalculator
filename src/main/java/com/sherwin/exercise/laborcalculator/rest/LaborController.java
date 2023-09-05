package com.sherwin.exercise.laborcalculator.rest;

import com.sherwin.exercise.laborcalculator.domain.entity.Labor;
import com.sherwin.exercise.laborcalculator.domain.service.LaborCalculatorService;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.LaborCalculatorMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorFrontEndRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaborCalculatorController {

    @Autowired
    private LaborCalculatorService laborCalculatorService;
    @Autowired
    private LaborCalculatorMapper laborCalculatorMapper;
    // think about better names for endpoints (nouns)
    // google API correct convention URL construction
    // 201 = created
    @PostMapping("labor/priceCalculation")
    /* Don't actually need the @Valid annotation since we have the ConstraintViolationException being handled in the
     Exception class, see MaterialCalculatorController, we are not using @Valid in the method, but we get same error message
     As expected thnanks to the exception class built that is handling all ConstraintViolationExceptions
    */
    //materializing
    private LaborCalculatorResponse getLaborCalculationPerSqft(@RequestBody @Valid LaborCalculatorFrontEndRequest frontEndRequest){

        // Convert from LaborCalculatedFrontEndRequest to LaborCalculatedRequest
        LaborCalculatorRequest laborCalculatorRequest = laborCalculatorMapper.convertLaborCalculatedFrontEndRequestToLaborCalculatorRequest(frontEndRequest);

        // Calculated object returned
        Labor labor = laborCalculatorService.calculateLabor(laborCalculatorRequest);

       // Mapping calculated object to response DTO to send back as a response
       return laborCalculatorMapper.convertLaborCalculatedtoLaborCalculatorResponse(labor);

    }
}
