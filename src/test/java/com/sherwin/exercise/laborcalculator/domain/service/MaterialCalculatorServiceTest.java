package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculated;
import com.sherwin.exercise.laborcalculator.domain.entity.MaterialCalculated;
import com.sherwin.exercise.laborcalculator.domain.service.LaborCalculatorService;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MaterialCalculatorServiceTest {

    @InjectMocks
    MaterialCalculatorService materialCalculatorService;

    @Mock
    MaterialCalculatorService mockMaterialCalculatorService;

    @Mock
    MaterialCalculated materialCalculated;

    @Mock
    MaterialCalculatorRequest materialCalculatorRequest;

    @Test
    public void checkMaterialCalculationFormulaWorks(){

        // This is the front-end request coming in
        MaterialCalculatorRequest request = new MaterialCalculatorRequest(12.0, 14.0, 300);

        // This is the expected result object to compare the calculation to.
        MaterialCalculated correctMaterialCalculation = new MaterialCalculated(((int) Math.random()*1000+1), 12.0,14.0, 300, 0.56);

        MaterialCalculated calculatedMaterials = materialCalculatorService.calculateGallonsPerSqft(request);

        // Compares the calculated price vs the expected price
        Assertions.assertTrue(correctMaterialCalculation.gallonsRequired == calculatedMaterials.gallonsRequired);
    }


    @Test
    public void checkFrontEndRequestConvertsToMaterialCalculatedObject() {

        when(mockMaterialCalculatorService.calculateGallonsPerSqft(materialCalculatorRequest)).thenReturn(materialCalculated);
    }
}
