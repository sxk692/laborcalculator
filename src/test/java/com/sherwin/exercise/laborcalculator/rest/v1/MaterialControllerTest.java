package com.sherwin.exercise.laborcalculator.rest.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sherwin.exercise.laborcalculator.domain.service.MaterialService;
import com.sherwin.exercise.laborcalculator.rest.MaterialController;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.MaterialMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborFrontEndRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialFrontEndRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialRequest;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialResponse;
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
import java.io.IOException;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MaterialController.class)
public class MaterialControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    MaterialService materialService;
    @MockBean
    MaterialMapper materialMapper;
    @Mock
    MaterialRequest materialRequest;
    @Mock
    MaterialResponse materialResponse;
    private ObjectMapper objectMapper;

    @BeforeEach
        // Creates an object mapper to map an object to a JSON string for below tests
    void setup() throws IOException {
        JavaTimeModule module = new JavaTimeModule();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);
    }
    @Test
    public void given_MaterialFrontEndRequest_willReturn_MaterialResponse() throws Exception {
        MaterialFrontEndRequest frontEndRequest = new MaterialFrontEndRequest(12,14,2);
        //Can this somehow be used in this test
//        MvcResult result = mvc.perform(post("/labor/priceCalculation")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)
//                        .content(objectMapper.writeValueAsString(frontEndRequest)))
//                .andReturn();

        given(materialMapper.convertMaterialToMaterialResponse(materialService. calculateGallonsPerSqft(materialMapper.convertMaterialFrontEndRequestToMaterialRequest(frontEndRequest))))
                .willReturn(materialResponse);

    }

    @Test
    public void checkAttributesOfMaterialCalculatorRequest() throws Exception {

        MvcResult result = mvc.perform(post("/materials/gallons")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(materialRequest)))
                .andReturn();
        // Shows the request object info in console
        System.out.println(result.getRequest().getContentAsString());

        String frontEndJsonRequest = result.getRequest().getContentAsString();

        Assertions.assertTrue(frontEndJsonRequest.contains("length"));
        Assertions.assertTrue(frontEndJsonRequest.contains("width"));
        Assertions.assertTrue(frontEndJsonRequest.contains("sqftPerGallon"));

    }

//    @Test
//    public void get200ResponseWhenSendingPostToGallonsEndpoint() throws Exception {
//        // Checks whether we get a 200 when sending a post to this endpoint
//        mvc.perform(post("/materials/gallonsNeededCalculation")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)
//                        .content(objectMapper.writeValueAsString(materialRequest)))
//                .andExpect(status().isOk());
//    }
//

}
