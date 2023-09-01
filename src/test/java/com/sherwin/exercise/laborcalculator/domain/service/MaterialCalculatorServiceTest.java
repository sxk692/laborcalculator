package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.entity.MaterialCalculated;
import com.sherwin.exercise.laborcalculator.domain.respositories.IMaterialCalculatedRepository;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorRequest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class MaterialCalculatorServiceTest {

    @InjectMocks
    MaterialCalculatorService materialCalculatorService;

    @Mock
    MaterialCalculatorService mockMaterialCalculatorService;

    @Mock
    IMaterialCalculatedRepository materialCalculatedRepository;
    @Mock
    MaterialCalculated materialCalculated;

    @Mock
    MaterialCalculatorRequest materialCalculatorRequest;

    @Test
    public void checkMaterialCalculationFormulaWorks(){

        // This is the front-end request coming in
        MaterialCalculatorRequest request = new MaterialCalculatorRequest(12.0, 14.0, 300);

        // This is the expected result object to compare the calculation to.
        MaterialCalculated correctMaterialCalculation = new MaterialCalculated(12.0,14.0, 300, 0.56);

        MaterialCalculated calculatedMaterials = materialCalculatorService.calculateGallonsPerSqft(request);

        // Compares the calculated price vs the expected price
        Assertions.assertTrue(correctMaterialCalculation.getGallonsRequired() == calculatedMaterials.getGallonsRequired());
    }


    @Test
    public void checkFrontEndRequestConvertsToMaterialCalculatedObject() {

        lenient().when(mockMaterialCalculatorService.calculateGallonsPerSqft(materialCalculatorRequest)).thenReturn(materialCalculated);
    }
}
