package com.sherwin.exercise.laborcalculator.rest;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculated;
import com.sherwin.exercise.laborcalculator.domain.service.LaborCalculatorService;
import com.sherwin.exercise.laborcalculator.rest.resources.v1.LaborCalculatorRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LaborCalculatorController.class)
public class LaborCalculatorControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    LaborCalculatorService laborCalculatorService;

    private ObjectMapper objectMapper;

    @BeforeEach
    // Creates an object mapper to map an object to a JSON string for below tests
            void setup() throws IOException{
        JavaTimeModule module = new JavaTimeModule();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);
    }
    LaborCalculated laborCalculated = new LaborCalculated(10001, 9380.0,134, 20, 3.50);
    LaborCalculatorRequest request = new LaborCalculatorRequest(134,20,3.50);

    @Test
    public void get200ResponseWhenSendingPostToLaborPriceEndpoint() throws Exception {
        // Checks whether we get a 200 when sending a post to this endpoint
         mvc.perform(post("/labor/price")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
}
