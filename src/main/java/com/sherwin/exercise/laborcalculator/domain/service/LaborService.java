package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.entity.Labor;
import com.sherwin.exercise.laborcalculator.domain.respositories.ILaborCalculatedRepository;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LaborCalculatorService {

    //TODO: Should these be private??
    @Autowired private ILaborCalculatedRepository laborCalculatedRepository;

    // Old code, not ideal to have mapper in service, moved mapper to controller
//    public LaborResponse frontendRequestToCalculatedLabor(LaborRequest request){
//
//        // Create new labor calculated object to send to a response DTO
//        Labor calculatedLabor = calculateLabor(request);
//        // Save in repository
//        laborCalculatedRepository.save(calculatedLabor);
//        return laborCalculatorMapper.convertLaborCalculatedtoLaborCalculatorResponse(calculatedLabor);
//    }

    /*
    1. Takes in front-end request information as parameter to calculate labor
    2. Calculated labor information is converted into a new Labor object
    3. Labor object is mapped to a response object to send back
     */
    public Labor calculateLabor(LaborRequest request){

        // Calculate price
        double price = request.getLength() * request.getWidth() * request.getPricePerSqft();

        // Create new object with the price that was calculated
        Labor labor = new Labor(-1,request.getLength(), request.getWidth(), request.getPricePerSqft(), price, new Date());

        // Save to repository (returns Labor object with right Id)
       return laborCalculatedRepository.save(labor);
    }
}
