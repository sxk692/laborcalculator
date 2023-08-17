package com.sherwin.exercise.laborcalculator.service;

import com.sherwin.exercise.laborcalculator.model.LaborCalculator;
import com.sherwin.exercise.laborcalculator.model.LaborCalculatorResponse;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LaborCalculatorService {


    // If I'm going to be destructure the json object in the post method in the controller, then
    // I could use this method since I could use the destructured variables as inputs to the method.
    public double calculateLabor(double length, double width, double pricePerSqft){
       return length * width * pricePerSqft;
    }
    public LaborCalculatorResponse calculateLabor(LaborCalculator laborCalculatorObject){
        double price = laborCalculatorObject.length * laborCalculatorObject.width;
        double id = Math.random() * 10000 +1 ;
        return new LaborCalculatorResponse((int)id,price);

    }
    public double calculateGallonsPerSqft(LaborCalculator laborCalculatorObject){
        return laborCalculatorObject.length * laborCalculatorObject.width / laborCalculatorObject.sqftPerGallon;
    }
}
