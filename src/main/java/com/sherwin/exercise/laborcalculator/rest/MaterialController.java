package com.sherwin.exercise.laborcalculator.rest;

import com.sherwin.exercise.laborcalculator.domain.entity.Material;
import com.sherwin.exercise.laborcalculator.domain.service.MaterialService;
import com.sherwin.exercise.laborcalculator.infrastructure.MaterialCalculation;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.MaterialMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialController {

    @Autowired
    private MaterialMapper materialMapper;
    @Autowired
    private MaterialService materialService;
    // no verbs, hieracrchical relationships
    @PostMapping("materials/calculations/gallons-required")
    @ResponseStatus(HttpStatus.CREATED)
    private MaterialResponse getGallonsRequiredPerSqft(@RequestBody @Valid MaterialRequest frontEndRequest){

        // Convert from MaterialFrontEndRequest to MaterialRequest
        MaterialCalculation materialCalculation = materialMapper.convertMaterialRequestToMaterialCalculation(frontEndRequest);

        // Calculated material object returned
        Material material = materialService.saveMaterial(materialCalculation);

        // Calculated material object mapped to response DTO
        return materialMapper.convertMaterialToMaterialResponse(material);
    }
}
