package com.sherwin.exercise.laborcalculator.rest.resources.mappers;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculated;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LaborCalculatorMapper {

    // Convert front-end request object to request DTO
    LaborCalculatorRequest convertFrontEndRequestToLaborCalculatorRequest(LaborCalculatorRequest request);

    // Convert from LaborCalculatorRequest to LaborCalculated object
    LaborCalculated convertFrontEndRequestToLaborCalculated(LaborCalculatorRequest request);

    // Convert from LaborCalculated object to LaborCalculatorResponse object
    LaborCalculatorResponse convertLaborCalculatedtoLaborCalculatorResponse(LaborCalculated calculatedLabor);

}
