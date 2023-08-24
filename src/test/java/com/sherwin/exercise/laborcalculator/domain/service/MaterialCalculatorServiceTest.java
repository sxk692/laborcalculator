package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculated;
import com.sherwin.exercise.laborcalculator.domain.entity.MaterialCalculated;
import com.sherwin.exercise.laborcalculator.domain.service.LaborCalculatorService;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;

public class MaterialCalculatorServiceTest {

    @MockBean
    MaterialCalculatorService materialCalculatorService;

    @Test
    public void checkMaterialCalculationFormulaWorks(){

        // Why do I need this if I already have a mockbean for this service? Commenting this out fails the test as
        // it shows null for the service.
        materialCalculatorService = new MaterialCalculatorService();

        // This is the front-end request coming in
        MaterialCalculatorRequest request = new MaterialCalculatorRequest(12.0, 14.0, 300);

        // This is the expected result object to compare the calculation to.
        MaterialCalculated correctMaterialCalculation = new MaterialCalculated(10001, 12.0,14.0, 300, 0.56);

        MaterialCalculated calculatedMaterials = materialCalculatorService.calculateGallonsPerSqft(request);

        // Compares the calculated price vs the expected price
        Assertions.assertTrue(correctMaterialCalculation.gallonsRequired == calculatedMaterials.gallonsRequired);
    }

    @Test
    public void checkFrontEndRequestConvertsToMaterialCalculatedObject() {

        materialCalculatorService = new MaterialCalculatorService();

        MaterialCalculated materialCalculated= new MaterialCalculated(10001, 12.0,14.0, 300, 0.56);

        MaterialCalculatorRequest request = new MaterialCalculatorRequest(12.0, 14.0, 300);

        given(materialCalculatorService.calculateGallonsPerSqft(request)).willReturn(materialCalculated);
    }
}
