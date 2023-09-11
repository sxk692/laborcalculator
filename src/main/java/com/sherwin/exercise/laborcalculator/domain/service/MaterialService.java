package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.entity.Material;
import com.sherwin.exercise.laborcalculator.domain.respositories.IMaterialRepository;
import com.sherwin.exercise.laborcalculator.infrastructure.MaterialCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MaterialService {

    @Autowired
    private IMaterialRepository materialCalculatedRepository;
    /*
    1. Takes in front-end request information as parameter to calculate materials
    2. Calculated material information is converted into a new Material object
    3. Material object is mapped to a response object to send back
     */
    public Material saveMaterial(MaterialCalculation request){

        // Calculate required number of gallons
        double gallons = calculateGallons(request);

        // Create new object with required number of gallons
        Material material = new Material(-1, request.getLength(), request.getWidth(), request.getSqftPerGallon(), gallons, new Date());

        // Save to repository
        Material calculatedMaterial =  materialCalculatedRepository.save(material);

        // Set id of material object from repo object
        material.setId(calculatedMaterial.getId());

        return material;
    }

    public double calculateGallons(MaterialCalculation request){
        return request.getLength() * request.getWidth() / request.getSqftPerGallon();
    }
}
