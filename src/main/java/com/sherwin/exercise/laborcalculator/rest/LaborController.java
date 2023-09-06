package com.sherwin.exercise.laborcalculator.rest;

import com.sherwin.exercise.laborcalculator.domain.entity.Labor;
import com.sherwin.exercise.laborcalculator.domain.service.LaborService;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.LaborMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborFrontEndRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaborController {

    @Autowired
    private LaborService laborService;
    @Autowired
    private LaborMapper laborMapper;
    // think about better names for endpoints (nouns)
    // google API correct convention URL construction
    // 201 = created
    @PostMapping("labor/priceCalculation")
    /* Don't actually need the @Valid annotation since we have the ConstraintViolationException being handled in the
     Exception class, see MaterialController, we are not using @Valid in the method, but we get same error message
     As expected thnanks to the exception class built that is handling all ConstraintViolationExceptions
    */
    //materializing
    private LaborResponse getLaborCalculationPerSqft(@RequestBody @Valid LaborFrontEndRequest frontEndRequest){

        // Convert from LaborCalculatedFrontEndRequest to LaborCalculatedRequest
        LaborRequest laborRequest = laborMapper.convertLaborFrontEndRequestToLaborRequest(frontEndRequest);

        // Calculated object returned
        Labor labor = laborService.calculateLabor(laborRequest);

       // Mapping calculated object to response DTO to send back as a response
       return laborMapper.convertLaborToLaborResponse(labor);

    }
}
