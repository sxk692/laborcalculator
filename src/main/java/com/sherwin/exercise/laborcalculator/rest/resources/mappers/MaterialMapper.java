package com.sherwin.exercise.laborcalculator.rest.resources.mappers;

import com.sherwin.exercise.laborcalculator.domain.entity.Material;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialCalculatorMapper {

    // Convert from Material object to MaterialResponse object
    MaterialResponse convertMaterialCalculatedtoMaterialCalculatorResponse(Material calculatedMaterials);

    MaterialRequest convertMaterialCalculatorFrontEndRequestToMaterialCalculatorRequest (MaterialFrontEndRequest request);

}
