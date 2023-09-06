package com.sherwin.exercise.laborcalculator.rest;

import com.sherwin.exercise.laborcalculator.domain.entity.Material;
import com.sherwin.exercise.laborcalculator.domain.service.MaterialService;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.MaterialMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialFrontEndRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialController {

    @Autowired
    private MaterialMapper materialMapper;
    @Autowired
    private MaterialService materialService;
    @PostMapping("materials/gallonsNeededCalculation")
    private MaterialResponse getGallonsRequiredPerSqft(@RequestBody @Valid MaterialFrontEndRequest request){

        // Convert from MaterialFrontEndRequest to MaterialRequest
        MaterialRequest materialRequest = materialMapper.convertMaterialFrontEndRequestToMaterialRequest(request);

        // Calculated material object returned
        Material material = materialService.calculateGallonsPerSqft(materialRequest);

        // Calculated material object mapped to response DTO
        return materialMapper.convertMaterialToMaterialResponse(material);
    }
}
