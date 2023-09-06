package com.sherwin.exercise.laborcalculator.rest.resources.mappers;

import com.sherwin.exercise.laborcalculator.domain.entity.Material;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialMapper {

    // Convert from Material object to MaterialResponse object
    MaterialResponse convertMaterialToMaterialResponse(Material calculatedMaterials);

    MaterialRequest convertMaterialFrontEndRequestToMaterialRequest(MaterialFrontEndRequest request);

}
