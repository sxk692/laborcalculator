package com.sherwin.exercise.laborcalculator.rest.mappers;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculated;
import com.sherwin.exercise.laborcalculator.domain.service.LaborCalculatorService;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.LaborCalculatorMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;


// This doe not work yet
//@RunWith(MockitoJUnitRunner.class)
//public class LaborCalculatorMapperTest {
//
//    //TODO: Figure out how to inject mock something that is being created behind the scenes such as the mapper interface
//    @InjectMocks
//    LaborCalculatorMapper laborCalculatorMapper;
//    @Mock
//    LaborCalculatorService mockLaborCalculatorService;
//    @Mock
//    LaborCalculatorRequest mockLaborCalculatorRequest;
//    @Mock
//    LaborCalculatorResponse mockLaborCalculatorResponse;
//    @Mock
//    LaborCalculated mockLaborCalculated;
//    @Test
//    public void checkLaborCalculatedConvertsToLaborCalculatedResponse() {
//        // When we supply a LaborCalculated object to mapper, we return a LaborCalculatedResponse DTO
//        when(laborCalculatorMapper.convertLaborCalculatedtoLaborCalculatorResponse(mockLaborCalculated)).thenReturn(mockLaborCalculatorResponse);
//    }
//}
