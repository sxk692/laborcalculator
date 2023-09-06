package com.sherwin.exercise.laborcalculator.rest.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sherwin.exercise.laborcalculator.domain.service.LaborService;
import com.sherwin.exercise.laborcalculator.rest.LaborController;
import com.sherwin.exercise.laborcalculator.rest.resources.mappers.LaborMapper;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborFrontEndRequest;
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

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// spring security will need to use ccrf.
@WebMvcTest(LaborController.class)
public class LaborControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    LaborService laborService;
    @MockBean
    LaborMapper laborMapper;
    @Mock
    LaborRequest laborRequest;
    @Mock
    LaborResponse laborResponse;
    private ObjectMapper objectMapper;

    @BeforeEach
    // Creates an object mapper to map an object to a JSON string for below tests
    void setup() {
        JavaTimeModule module = new JavaTimeModule();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);
    }


    @Test
    public void given_LaborFrontEndRequest_willReturn_LaborResponse() throws Exception {
        LaborFrontEndRequest frontEndRequest = new LaborFrontEndRequest(12,14,2);
        //Can this somehow be used in this test
        MvcResult result = mvc.perform(post("/labor/priceCalculation")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(frontEndRequest)))
                .andReturn();



        given(laborMapper.convertLaborToLaborResponse(laborService.calculateLabor(laborMapper.convertLaborFrontEndRequestToLaborRequest(frontEndRequest))))
                .willReturn(laborResponse);

    }
    // normally care about end result, whereas this is more of a validation test.
    @Test
    public void checkRequiredFieldsExistInLaborFrontEndRequest() throws Exception{
        LaborFrontEndRequest frontEndRequest = new LaborFrontEndRequest(10,10,2);
        MvcResult result = mvc.perform(post("/labor/priceCalculation")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(frontEndRequest)))
                .andReturn();

//        LaborResponse response = objectMapper.readValue(result.getRequest().getContentAsString(), LaborResponse.class);
//        Assertions.assertTrue(response.getPrice() == 200);

        String frontEndJsonRequest = result.getRequest().getContentAsString();
//
        Assertions.assertTrue(frontEndJsonRequest.contains("length"));
        Assertions.assertTrue(frontEndJsonRequest.contains("width"));
        Assertions.assertTrue(frontEndJsonRequest.contains("pricePerSqft"));
    }

//    @Test
//    public void get200ResponseWhenSendingPostToLaborEndpoint() throws Exception {
//        LaborRequest request = new LaborRequest(134,20,3.50);
//        // Checks whether we get a 200 when sending a post to this endpoint
//         mvc.perform(post("/labor/priceCalculation")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isOk());
//    }
    // one success, 2 failures
    // work on responses received
    // naming conventions

}
