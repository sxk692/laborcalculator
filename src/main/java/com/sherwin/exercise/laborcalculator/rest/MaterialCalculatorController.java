package com.sherwin.exercise.laborcalculator.rest;

import com.sherwin.exercise.laborcalculator.domain.entity.MaterialCalculated;
import com.sherwin.exercise.laborcalculator.domain.service.MaterialCalculatorService;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.MaterialCalculatorMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorResponse;
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
    @PostMapping("materials/gallons")
    private MaterialCalculatorResponse getGallonsRequiredPerSqft(@RequestBody MaterialCalculatorRequest request){
        // Calculated material object returned
        MaterialCalculated materialCalculated = materialCalculatorService.calculateGallonsPerSqft(request);
        // Calculated material object mapped to response DTO
        return materialCalculatorMapper.convertMaterialCalculatedtoMaterialCalculatorResponse(materialCalculated);
    }
}
