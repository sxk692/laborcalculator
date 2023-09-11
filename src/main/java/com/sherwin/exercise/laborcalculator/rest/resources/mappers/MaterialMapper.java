package com.sherwin.exercise.laborcalculator.rest.resources.mappers;

import com.sherwin.exercise.laborcalculator.domain.entity.Material;
import com.sherwin.exercise.laborcalculator.infrastructure.MaterialCalculation;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialMapper {

    MaterialResponse convertMaterialToMaterialResponse(Material calculatedMaterials);

    MaterialCalculation convertMaterialRequestToMaterialCalculation(MaterialRequest request);
}
