package com.sherwin.exercise.laborcalculator.rest;

import com.sherwin.exercise.laborcalculator.domain.entity.Material;
import com.sherwin.exercise.laborcalculator.domain.service.MaterialCalculatorService;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.MaterialCalculatorMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorFrontEndRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialCalculatorController {

    @Autowired
    private MaterialCalculatorMapper materialCalculatorMapper;
    @Autowired
    private MaterialCalculatorService materialCalculatorService;
    @PostMapping("materials/gallonsNeededCalculation")
    private MaterialCalculatorResponse getGallonsRequiredPerSqft(@RequestBody @Valid MaterialCalculatorFrontEndRequest request){

        // Convert from MaterialCalculatorFrontEndRequest to MaterialCalculatorRequest
        MaterialCalculatorRequest materialCalculatorRequest = materialCalculatorMapper.convertMaterialCalculatorFrontEndRequestToMaterialCalculatorRequest(request);

        // Calculated material object returned
        Material material = materialCalculatorService.calculateGallonsPerSqft(materialCalculatorRequest);

        // Calculated material object mapped to response DTO
        return materialCalculatorMapper.convertMaterialCalculatedtoMaterialCalculatorResponse(material);
    }
}
