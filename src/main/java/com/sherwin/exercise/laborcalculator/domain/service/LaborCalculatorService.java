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

    //TODO: Should these be private??
    @Autowired private ILaborCalculatedRepository laborCalculatedRepository;

    // Old code, not ideal to have mapper in service, moved mapper to controller
//    public LaborCalculatorResponse frontendRequestToCalculatedLabor(LaborCalculatorRequest request){
//
//        // Create new labor calculated object to send to a response DTO
//        LaborCalculated calculatedLabor = calculateLabor(request);
//        // Save in repository
//        laborCalculatedRepository.save(calculatedLabor);
//        return laborCalculatorMapper.convertLaborCalculatedtoLaborCalculatorResponse(calculatedLabor);
//    }

    /*
    1. Takes in front-end request information as parameter to calculate labor
    2. Calculated labor information is converted into a new LaborCalculated object
    3. LaborCalculated object is mapped to a response object to send back
     */
    public LaborCalculated calculateLabor(LaborCalculatorRequest request){

        // Calculate price
        double price = request.getLength() * request.getWidth() * request.getPricePerSqft();

        // Create new object with the price that was calculated
        LaborCalculated laborCalculated  = new LaborCalculated(price, request.getLength(), request.getWidth(), request.getPricePerSqft());

        // Save to repository
        laborCalculatedRepository.save(laborCalculated);

        return laborCalculated;
    }
}
