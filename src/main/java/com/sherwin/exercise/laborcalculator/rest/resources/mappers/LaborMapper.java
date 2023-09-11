package com.sherwin.exercise.laborcalculator.rest.resources.mappers;

import com.sherwin.exercise.laborcalculator.domain.entity.Labor;
import com.sherwin.exercise.laborcalculator.infrastructure.LaborCalculation;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LaborMapper {

    // Convert from Labor object to LaborResponse DTO
    LaborResponse convertLaborToLaborResponse(Labor calculatedLabor);

//    LaborResponse convertLaborCalculationToLaborResponse(LaborCalculation laborCalculation);

//    LaborRequest convertLaborFrontEndRequestToLaborRequest(LaborFrontEndRequest request);

    LaborCalculation convertLaborRequestToLaborCalculation(LaborRequest request);

}
