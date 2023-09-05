package com.sherwin.exercise.laborcalculator.rest.resources.mappers;

import com.sherwin.exercise.laborcalculator.domain.entity.Labor;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorFrontEndRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LaborCalculatorMapper {

    // Convert from Labor object to LaborCalculatorResponse DTO
    LaborCalculatorResponse convertLaborCalculatedtoLaborCalculatorResponse(Labor calculatedLabor);

    LaborCalculatorRequest convertLaborCalculatedFrontEndRequestToLaborCalculatorRequest (LaborCalculatorFrontEndRequest request);

}
