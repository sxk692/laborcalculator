package com.sherwin.exercise.laborcalculator.rest.resources.mappers;

import com.sherwin.exercise.laborcalculator.domain.entity.MaterialCalculated;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialCalculatorMapper {

    // Convert from MaterialCalculated object to MaterialCalculatorResponse object
    MaterialCalculatorResponse convertMaterialCalculatedtoMaterialCalculatorResponse(MaterialCalculated calculatedMaterials);

}
