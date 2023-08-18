package com.sherwin.exercise.laborcalculator.rest.resources.mappers;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculator;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LaborCalculatorMapper {

    // For request to response DTO
    LaborCalculatorResponse convertLaborCalculatorToLaborCalculatorResponse(LaborCalculator calculated);

    // For front-end request object to request DTO
    LaborCalculatorRequest convertFrontEndRequestToLaborCalculatorRequest(LaborCalculatorRequest frontEndRequest);

    LaborCalculator convertFrontEndRequestToLaborCalculator(LaborCalculatorRequest request);

}
