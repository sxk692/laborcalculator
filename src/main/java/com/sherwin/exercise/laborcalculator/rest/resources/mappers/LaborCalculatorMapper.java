package com.sherwin.exercise.laborcalculator.rest.resources.mappers;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculated;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LaborCalculatorMapper {

    // Convert from LaborCalculated object to LaborCalculatorResponse object
    LaborCalculatorResponse convertLaborCalculatedtoLaborCalculatorResponse(LaborCalculated calculatedLabor);

}
