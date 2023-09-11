package com.sherwin.exercise.laborcalculator.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sherwin.exercise.laborcalculator.domain.entity.Material;
import com.sherwin.exercise.laborcalculator.domain.respositories.IMaterialRepository;
import com.sherwin.exercise.laborcalculator.domain.service.MaterialService;
import com.sherwin.exercise.laborcalculator.infrastructure.MaterialCalculation;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.MaterialMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(MaterialController.class)
public class MaterialControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private MaterialService materialService;
    @MockBean
    private IMaterialRepository materialRepository;
    @MockBean
    private MaterialMapper materialMapper;
    @Mock
    private MaterialRequest materialRequest;
    @Mock
    private MaterialResponse materialResponse;

    @BeforeEach
    // Creates an object mapper to map an object to a JSON string for below tests
    void setup() throws IOException {
        JavaTimeModule module = new JavaTimeModule();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);
    }
    @Test
    public void material_GallonsCalculation_Returns_Created() throws Exception{

        MaterialRequest frontEndRequest =  new MaterialRequest(10,2,3);

        mvc.perform(post("/material/calculations/gallons-required")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(frontEndRequest)))
                        .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    // this isn't working, even tho it's the same exact code essentially from LaborControllerTest
    @Test
    public void check_Response_Contains_All_Necessary_Fields () throws Exception{

        MaterialRequest request = new MaterialRequest(10,10,2);
        MaterialCalculation materialCalculation = new MaterialCalculation(10,10,2,50);
        Material material = new Material(1,10,10,2,50, new Date());
        MaterialResponse response = new MaterialResponse(1,50);

        given(materialMapper.convertMaterialRequestToMaterialCalculation(any())).willReturn(materialCalculation);
        given(materialRepository.save(any())).willReturn(material);
        given(materialService.saveMaterial(any())).willReturn(material);
        given(materialMapper.convertMaterialToMaterialResponse(any())).willReturn(response);

        //checks if things are wired up correctly, not actual integration
        //not getting proper response
        mvc.perform(post("/material/calculations/gallons-required")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("gallonsRequired").exists());

    }
}
