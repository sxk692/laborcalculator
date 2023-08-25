package com.sherwin.exercise.laborcalculator.rest;

import com.sherwin.exercise.laborcalculator.domain.service.MaterialCalculatorService;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialCalculatorController {

    @Autowired
    MaterialCalculatorService materialCalculatorService;
    @PostMapping("materials/gallons")
    public MaterialCalculatorResponse getGallonsRequiredPerSqft(@RequestBody MaterialCalculatorRequest bodyValues){
        return materialCalculatorService.frontendRequestToCalculatedMaterialCalculatorResponse(bodyValues);
    }
}