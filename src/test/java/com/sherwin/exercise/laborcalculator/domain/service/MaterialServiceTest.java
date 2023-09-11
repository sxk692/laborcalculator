package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.entity.Material;
import com.sherwin.exercise.laborcalculator.domain.respositories.IMaterialRepository;
import com.sherwin.exercise.laborcalculator.infrastructure.MaterialCalculation;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialRequest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MaterialServiceTest {

    @InjectMocks
    MaterialService materialService;
    @Mock
    IMaterialRepository materialCalculatedRepository;
    @Mock
    Material material;
    @Mock
    MaterialRequest materialRequest;
    @Test
    public void check_material_calculation_formula() {

        MaterialCalculation materialCalculation = new MaterialCalculation(12.0, 14.0, 300,0);

        double correctMaterialCalculation = 0.56;

        double gallons = materialService.calculateGallons(materialCalculation);

        Assertions.assertTrue(gallons == correctMaterialCalculation);
    }
}
