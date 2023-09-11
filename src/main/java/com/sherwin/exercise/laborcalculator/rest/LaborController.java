package com.sherwin.exercise.laborcalculator.rest;

import com.sherwin.exercise.laborcalculator.domain.entity.Labor;
import com.sherwin.exercise.laborcalculator.domain.service.LaborService;
import com.sherwin.exercise.laborcalculator.infrastructure.LaborCalculation;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.LaborMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaborController {

    @Autowired
    private LaborService laborService;
    @Autowired
    private LaborMapper laborMapper;
    /*
    ConstraintViolationException is for entity to database constraints
    MethodArgumentNotValidException is for method input validation for our dtos

    Think about better names for endpoints (nouns)
    Google API correct convention URL construction
    201 = created
    */
    @PostMapping("labor/pricecalculation/create")
    //materializing
    @ResponseStatus(HttpStatus.CREATED)
    private LaborResponse getLaborCalculationPerSqft(@RequestBody @Valid LaborRequest frontEndRequest){

        // Convert from LaborCalculatedFrontEndRequest to LaborCalculatedRequest
        LaborCalculation laborCalculation = laborMapper.convertLaborRequestToLaborCalculation(frontEndRequest);

        // Calculated object returned
        Labor labor = laborService.saveLabor(laborCalculation);

       // Mapping calculated object to response DTO to send back as a response
       return laborMapper.convertLaborToLaborResponse(labor);

    }
}
