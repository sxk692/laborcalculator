package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.entity.Material;
import com.sherwin.exercise.laborcalculator.domain.respositories.IMaterialRepository;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialRequest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class MaterialServiceTest {

    @InjectMocks
    MaterialService materialService;

    @Mock
    MaterialService mockMaterialService;

    @Mock
    IMaterialRepository materialCalculatedRepository;
    @Mock
    Material material;

    @Mock
    MaterialRequest materialRequest;

    @Test
    public void checkMaterialCalculationFormulaWorks(){

        // This is the front-end request coming in
        MaterialRequest request = new MaterialRequest(12.0, 14.0, 300);

        // Calculate materials required using service
        Material calculatedMaterials = materialService.calculateGallonsPerSqft(request);

        // This is the expected result object to compare the calculation to.
        double correctMaterialCalculation = 0.56;

        // Compares the calculated price vs the expected price
        Assertions.assertTrue(correctMaterialCalculation == calculatedMaterials.getGallonsRequired());
    }


//    @Test
//    public void checkFrontEndRequestConvertsToMaterialCalculatedObject() {
//
//        lenient().w
//        hen(mockMaterialService.calculateGallonsPerSqft(materialRequest)).thenReturn(material);
//    }
}
