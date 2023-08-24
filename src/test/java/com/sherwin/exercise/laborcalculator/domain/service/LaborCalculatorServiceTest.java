package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculated;
import com.sherwin.exercise.laborcalculator.domain.service.LaborCalculatorService;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;

public class LaborCalculatorServiceTest {

    @MockBean
    LaborCalculatorService laborCalculatorService;

    @Test
    public void checkLaborCalculationFormulaWorks(){

        // Why do I need this if I already have a mockbean for this service? Commenting this out fails the test as
        // it shows null for the service.
        laborCalculatorService = new LaborCalculatorService();

        // This is the front-end request coming in
        LaborCalculatorRequest request = new LaborCalculatorRequest(134, 20, 3.50);

        // This is the expected result object to compare the calculation to.
        LaborCalculated correctLaborCalculation = new LaborCalculated(10001, 9380.0,134, 20, 3.50);

        double calculatedPrice = laborCalculatorService.calculateLabor(request).price;

        // Compares the calculated price vs the expected price
        Assertions.assertTrue(calculatedPrice == correctLaborCalculation.price);
    }

    @Test
    public void checkFrontEndRequestConvertsToLaborCalculatedObject() {

        laborCalculatorService = new LaborCalculatorService();

        LaborCalculated laborCalculated = new LaborCalculated(10001, 9380.0,134, 20, 3.50);

        LaborCalculatorRequest request = new LaborCalculatorRequest(134, 20, 3.5);

       given(laborCalculatorService.calculateLabor(request)).willReturn(laborCalculated);
    }
}
