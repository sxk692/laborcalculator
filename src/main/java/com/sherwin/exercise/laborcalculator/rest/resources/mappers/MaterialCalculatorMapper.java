package com.sherwin.exercise.laborcalculator.rest.resources.mappers;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculated;
import com.sherwin.exercise.laborcalculator.domain.entity.MaterialCalculated;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorResponse;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialCalculatorMapper {

    // Convert front-end request object to request DTO
    MaterialCalculatorRequest convertFrontEndRequestToMaterialCalculatorRequest(MaterialCalculatorRequest request);

    // Convert from MaterialCalculatedRequested to MaterialCalculated object
    MaterialCalculated convertFrontEndRequestToLaborCalculated(MaterialCalculatorRequest request);

    // Convert from MaterialCalculated object to MaterialCalculatorResponse object
    MaterialCalculatorResponse convertMaterialCalculatedtoMaterialCalculatorResponse(MaterialCalculated calculatedMaterials);

}
