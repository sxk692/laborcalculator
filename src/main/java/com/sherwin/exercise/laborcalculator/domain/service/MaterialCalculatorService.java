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

    //TODO: Should these be private??
    @Autowired
    IMaterialCalculatedRepository materialCalculatedRepository;

    // Old code, not ideal to have mapper in service, moved mapper to controller
//    public MaterialCalculatorResponse frontendRequestToCalculatedMaterialCalculatorResponse(MaterialCalculatorRequest request){
//
//        MaterialCalculated calculatedMaterials = calculateGallonsPerSqft(request);
//        // Save in repository
//        materialCalculatedRepository.save(calculatedMaterials);
//        return materialCalculatorMapper.convertMaterialCalculatedtoMaterialCalculatorResponse(calculatedMaterials);
//    }


    /*
    1. Takes in front-end request information as parameter to calculate materials
    2. Calculated material information is converted into a new MaterialCalculated object
    3. MaterialCalculated object is mapped to a response object to send back
     */
    public MaterialCalculated calculateGallonsPerSqft(MaterialCalculatorRequest request){

        // Calculate required number of gallons
        double gallons =  request.getLength() * request.getWidth() / request.getSqftPerGallon();

        // Create new object with required number of gallons
        MaterialCalculated materialCalculated = new MaterialCalculated(request.getLength(), request.getWidth(), request.getSqftPerGallon(), gallons);

        // Save to repository
        materialCalculatedRepository.save(materialCalculated);

        return materialCalculated;
    }
}
