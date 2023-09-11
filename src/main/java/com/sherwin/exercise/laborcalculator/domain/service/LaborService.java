package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.entity.Labor;
import com.sherwin.exercise.laborcalculator.domain.respositories.ILaborRepository;
import com.sherwin.exercise.laborcalculator.infrastructure.LaborCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LaborService {

    @Autowired
    private ILaborRepository laborCalculatedRepository;

    /*
    1. Takes in front-end request information as parameter to calculate labor
    2. Calculated labor information is converted into a new Labor object
    3. Labor object is mapped to a response object to send back
     */
    public Labor saveLabor(LaborCalculation request){

        // Calculate price
        double price = calculateLabor(request);

        // Create new object with the price that was calculated
        Labor labor = new Labor(-1,request.getLength(), request.getWidth(), request.getPricePerSqft(), price, new Date());

        // Save to repository (returns Labor object with right Id)

        Labor calculatedLaborWithNewId = laborCalculatedRepository.save(labor);

       // Set id of labor object with the repo id

        labor.setId(calculatedLaborWithNewId .getId());

        return labor;
    }

    public double calculateLabor (LaborCalculation request) {

        return request.getLength() * request.getWidth();

    }
}
