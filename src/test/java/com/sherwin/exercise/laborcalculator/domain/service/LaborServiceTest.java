package com.sherwin.exercise.laborcalculator.domain.service;

import com.sherwin.exercise.laborcalculator.domain.respositories.ILaborRepository;
import com.sherwin.exercise.laborcalculator.infrastructure.LaborCalculation;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class LaborServiceTest {

    @InjectMocks
    LaborService laborService;
    @Mock
    ILaborRepository laborRepository;

    @Test
    public void check_labor_calculation_formula() {

        double correctLaborCalculation = 40;

        LaborCalculation laborCalculation = new LaborCalculation(10, 2, 2, 0);

        double calculatedPrice = laborService.calculateLabor(laborCalculation);

        Assertions.assertTrue(correctLaborCalculation == calculatedPrice);
    }
}
