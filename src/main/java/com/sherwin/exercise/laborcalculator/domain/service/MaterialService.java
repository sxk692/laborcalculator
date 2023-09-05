package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.entity.Material;
import com.sherwin.exercise.laborcalculator.domain.respositories.IMaterialCalculatedRepository;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MaterialCalculatorService {

    //TODO: Should these be private??
    @Autowired
    IMaterialCalculatedRepository materialCalculatedRepository;

    // Old code, not ideal to have mapper in service, moved mapper to controller
//    public MaterialResponse frontendRequestToCalculatedMaterialCalculatorResponse(MaterialRequest request){
//
//        Material calculatedMaterials = calculateGallonsPerSqft(request);
//        // Save in repository
//        materialCalculatedRepository.save(calculatedMaterials);
//        return materialCalculatorMapper.convertMaterialCalculatedtoMaterialCalculatorResponse(calculatedMaterials);
//    }


    /*
    1. Takes in front-end request information as parameter to calculate materials
    2. Calculated material information is converted into a new Material object
    3. Material object is mapped to a response object to send back
     */
    public Material calculateGallonsPerSqft(MaterialRequest request){

        // Calculate required number of gallons
        double gallons =  request.getLength() * request.getWidth() / request.getSqftPerGallon();

        // Create new object with required number of gallons
        Material material = new Material(-1, new Date(), request.getLength(), request.getWidth(), request.getSqftPerGallon(), gallons);

        // Save to repository
        materialCalculatedRepository.save(material);

        return material;
    }
}
