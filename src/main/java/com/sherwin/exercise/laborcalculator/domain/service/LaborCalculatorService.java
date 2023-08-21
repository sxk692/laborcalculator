package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculated;
import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculator;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.LaborCalculatorMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaborCalculatorService {
    @Autowired
    LaborCalculatorMapper laborCalculatorMapper;

    /*
    1. Takes in front-end request information as parameter to calculate labor
    2. Calculated labor information is converted into a new LaborCalculated object
    3. LaborCalculated object is mapped to a response object to send back
     */
    // TODO: Change this to go from request pojo to LaborCalculated object, then when sending as response, map from LaborCalculated object to LaborCalculatorResponse object.
    public LaborCalculatorResponse frontendRequestToCalculatedLabor(LaborCalculatorRequest request){
        double price = request.length * request.width * request.pricePerSqft;
        double id = Math.random() * 10000 +1 ;
        // Create new labor calculated object (and tuple in database) to send to a response DTO...?
        return laborCalculatorMapper.convertLaborCalculatedtoLaborCalculatorResponse(new LaborCalculated((int)id, price));
    }

//    public LaborCalculatorResponse createLaborCalculatedResponse(LaborCalculated calculatedLabor) {
//        // Creates Calculated Labor Object
//        return laborCalculatorMapper.convertLaborCalculatedtoLaborCalculatorResponse(calculatedLabor);
//    }


    public double calculateGallonsPerSqft(LaborCalculator laborCalculatorObject){
        return laborCalculatorObject.length * laborCalculatorObject.width / laborCalculatorObject.sqftPerGallon;
    }
}
