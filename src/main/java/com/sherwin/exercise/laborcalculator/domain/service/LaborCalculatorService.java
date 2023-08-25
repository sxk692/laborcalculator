package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculated;
import com.sherwin.exercise.laborcalculator.domain.respositories.ILaborCalculatedRepository;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.LaborCalculatorMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaborCalculatorService {
    @Autowired
    LaborCalculatorMapper laborCalculatorMapper;
    @Autowired
    ILaborCalculatedRepository laborCalculatedRepository;

    /*
    1. Takes in front-end request information as parameter to calculate labor
    2. Calculated labor information is converted into a new LaborCalculated object
    3. LaborCalculated object is mapped to a response object to send back
     */
    public LaborCalculatorResponse frontendRequestToCalculatedLabor(LaborCalculatorRequest request){

        // Create new labor calculated object to send to a response DTO
        LaborCalculated calculatedLabor = calculateLabor(request);
        // Save in repository
        laborCalculatedRepository.save(calculatedLabor);
        return laborCalculatorMapper.convertLaborCalculatedtoLaborCalculatorResponse(calculatedLabor);
    }

    public LaborCalculated calculateLabor(LaborCalculatorRequest request){
        double price = request.getLength() * request.getWidth() * request.getPricePerSqft();
        return new LaborCalculated(price, request.getLength(), request.getWidth(), request.getPricePerSqft());
    }
}
