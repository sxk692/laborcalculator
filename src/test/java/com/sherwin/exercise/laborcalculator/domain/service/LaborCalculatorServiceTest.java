package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculated;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorResponse;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class LaborCalculatorServiceTest {

    @InjectMocks
    LaborCalculatorService laborCalculatorService;

    @Mock
    LaborCalculatorService mockLaborCalculatorService;

    @Mock
    LaborCalculated mockLaborCalculated;

    @Mock
    LaborCalculatorRequest mockLaborCalculatorRequest;

    @Mock
    LaborCalculatorResponse mockLaborCalculatorResponse;

    @Test
    public void checkLaborCalculationFormulaWorks(){

        // This is the front-end request coming in
        LaborCalculatorRequest request = new LaborCalculatorRequest(134, 20, 3.50);

        // This is the expected result object to compare the calculation to.
        LaborCalculated correctLaborCalculation = new LaborCalculated(9380.0,134, 20, 3.50);

        double calculatedPrice = laborCalculatorService.calculateLabor(request).getPrice();

        // Compares the calculated price vs the expected price
        Assertions.assertTrue(calculatedPrice == correctLaborCalculation.getPrice());
    }

    @Test
    public void checkFrontEndRequestConvertsToLaborCalculatedObject() {
        // When we supply a LaborCalculatorRequest, we return a LaborCalculated Object
       lenient().when(mockLaborCalculatorService.calculateLabor(mockLaborCalculatorRequest)).thenReturn(mockLaborCalculated);
    }

}
