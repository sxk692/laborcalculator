package com.sherwin.exercise.laborcalculator.domain.service;

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

    // Converts front-end received pojo to a backend LaborCalculatorRequest DTO, which is essentially the same...
    public LaborCalculatorResponse convertToRequestPojo(LaborCalculatorRequest frontEndRequest) {

        // Seems redundant and not doing anything.
        LaborCalculatorRequest request = laborCalculatorMapper.convertFrontEndRequestToLaborCalculatorRequest(frontEndRequest);
        return calculateLabor(request);
    }
    // Calculates labor and returns new object with that information.
    public LaborCalculatorResponse calculateLabor(LaborCalculatorRequest request){
        double price = request.length * request.width;
        double id = Math.random() * 10000 +1 ;
        // Create new backend object to send to a response DTO...?

        return new LaborCalculatorResponse((int)id, price);
    }

    public double calculateGallonsPerSqft(LaborCalculator laborCalculatorObject){
        return laborCalculatorObject.length * laborCalculatorObject.width / laborCalculatorObject.sqftPerGallon;
    }
}
