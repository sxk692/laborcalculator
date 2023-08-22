package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.entity.MaterialCalculated;
import com.sherwin.exercise.laborcalculator.domain.respositories.IMaterialCalculatedRepository;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.MaterialCalculatorMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialCalculatorService {
    @Autowired
    MaterialCalculatorMapper materialCalculatorMapper;
    @Autowired
    IMaterialCalculatedRepository materialCalculatedRepository;

    /*
    1. Takes in front-end request information as parameter to calculate materials
    2. Calculated material information is converted into a new MaterialCalculated object
    3. MaterialCalculated object is mapped to a response object to send back
     */
    public MaterialCalculatorResponse frontendRequestToCalculatedMaterialCalculatorResponse(MaterialCalculatorRequest request){
        double id = Math.random() * 10000 +1 ;
        double gallonsRequired = calculateGallonsPerSqft(request);
        // Create new labor calculated object to send to a response DTO
        MaterialCalculated calculatedMaterials = new MaterialCalculated((int)id, request.length, request.width, request.sqftPerGallon, gallonsRequired );
        // Save in repository
        materialCalculatedRepository.save(calculatedMaterials);
        return materialCalculatorMapper.convertMaterialCalculatedtoMaterialCalculatorResponse(calculatedMaterials);
    }

    public double calculateGallonsPerSqft(MaterialCalculatorRequest request){
        return request.length * request.width / request.sqftPerGallon;
    }
}
