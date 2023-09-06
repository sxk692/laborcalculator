package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.entity.Labor;
import com.sherwin.exercise.laborcalculator.domain.respositories.ILaborRepository;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborRequest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class LaborServiceTest {

    @InjectMocks
    LaborService laborService;

    @Mock
    ILaborRepository laborCalculatedRepository;

    @Mock
    LaborService mockLaborService;

    @Mock
    Labor mockLabor;

    @Mock
    LaborRequest mockLaborRequest;

    @Test
    public void checkLaborCalculationFormulaWorks(){

        // This is the front-end request coming in
        LaborRequest request = new LaborRequest(134, 20, 3.50);

        // This is the expected result object to compare the calculation to.
        // better to have this than a magic number
        double correctLaborCalculation = 9380;

        double calculatedPrice = laborService.calculateLabor(request).getPrice();

        // Compares the calculated price vs the expected price
        Assertions.assertTrue(calculatedPrice == correctLaborCalculation);
    }

//    @Test
//    //not necessary
//    public void checkFrontEndRequestConvertsToLaborCalculatedObject() {
//        // When we supply a LaborRequest, we return a Labor Object
//       lenient().when(mockLaborService.calculateLabor(mockLaborRequest)).thenReturn(mockLabor);
//    }
    //

}
