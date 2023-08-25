package com.sherwin.exercise.laborcalculator.rest.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sherwin.exercise.laborcalculator.domain.service.MaterialCalculatorService;
import com.sherwin.exercise.laborcalculator.rest.MaterialCalculatorController;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.MaterialCalculatorRequest;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MaterialCalculatorController.class)
public class MaterialCalculatorControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    MaterialCalculatorService materialCalculatorService;
    @Mock
    MaterialCalculatorRequest materialCalculatorRequest;
    private ObjectMapper objectMapper;

    @BeforeEach
        // Creates an object mapper to map an object to a JSON string for below tests
    void setup() throws IOException {
        JavaTimeModule module = new JavaTimeModule();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);
    }

    @Test
    public void get200ResponseWhenSendingPostToGallonsEndpoint() throws Exception {
        // Checks whether we get a 200 when sending a post to this endpoint
        mvc.perform(post("/materials/gallons")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(materialCalculatorRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void checkAttributesOfMaterialCalculatorRequest() throws Exception {

        MvcResult result = mvc.perform(post("/materials/gallons")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(materialCalculatorRequest)))
                .andReturn();
        // Shows the request object info in console
        System.out.println(result.getRequest().getContentAsString());

        String frontEndJsonRequest = result.getRequest().getContentAsString();

        Assertions.assertTrue(frontEndJsonRequest.contains("length"));
        Assertions.assertTrue(frontEndJsonRequest.contains("width"));
        Assertions.assertTrue(frontEndJsonRequest.contains("sqftPerGallon"));

    }

}
