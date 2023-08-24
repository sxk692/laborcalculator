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

        MaterialCalculated calculatedMaterials = calculateGallonsPerSqft(request);
        // Save in repository
        materialCalculatedRepository.save(calculatedMaterials);
        return materialCalculatorMapper.convertMaterialCalculatedtoMaterialCalculatorResponse(calculatedMaterials);
    }

    public MaterialCalculated calculateGallonsPerSqft(MaterialCalculatorRequest request){
        double gallons =  request.length * request.width / request.sqftPerGallon;
        // Hard coded for now for testing
        int id = 10001;
        return new MaterialCalculated(id, request.length, request.width, request.sqftPerGallon, gallons);
    }
}
