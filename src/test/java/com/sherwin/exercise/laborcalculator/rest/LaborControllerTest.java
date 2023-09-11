package com.sherwin.exercise.laborcalculator.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sherwin.exercise.laborcalculator.domain.entity.Labor;
import com.sherwin.exercise.laborcalculator.domain.respositories.ILaborRepository;
import com.sherwin.exercise.laborcalculator.domain.service.LaborService;
import com.sherwin.exercise.laborcalculator.infrastructure.LaborCalculation;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.LaborMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


// spring security will need to use ccrf.
@WebMvcTest(LaborController.class)
public class LaborControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private LaborService laborService;
    @MockBean
    private LaborMapper laborMapper;
    @MockBean
    private ILaborRepository laborRepository;
    @Mock
    private LaborRequest laborRequest;
    @Mock
    private LaborResponse laborResponse;

    @BeforeEach
    // Creates an object mapper to map an object to a JSON string for below tests
    void setup() {
        JavaTimeModule module = new JavaTimeModule();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);
    }

    @Test void labor_pricecalculation_Endpoint_Returns_Created_201() throws Exception {

        LaborRequest frontEndRequest = new LaborRequest(12,14,2);
        mvc.perform(post("/labor/calculation/price")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(frontEndRequest)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    // Trying to figure out how to get an actual response body to see if it matches expected response body
    @Test
    void check_Response_Contains_All_Necessary_Fields () throws Exception{

        LaborRequest request = new LaborRequest(10,10,2);
        LaborCalculation laborCalculation = new LaborCalculation(10,10,2,200);
        Labor labor = new Labor(1,10,10,2,200,new Date());
        LaborResponse response = new LaborResponse(1,200);

        given(laborMapper.convertLaborRequestToLaborCalculation(any())).willReturn(laborCalculation);
        given(laborRepository.save(any())).willReturn(labor);
        given(laborService.saveLabor(any())).willReturn(labor);
//        given(laborMapper.convertLaborToLaborResponse(any())).willReturn(response);

        // Cannot get proper response object
        MvcResult result =  this.mvc.perform(post("/labor/calculation/price")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
//                .andExpect(MockMvcResultMatchers.jsonPath("price").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("id").exists())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());


    }
}

