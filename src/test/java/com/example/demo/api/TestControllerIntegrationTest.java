package com.example.demo.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Victor Wardi - @victorwardi
 */
@SpringBootTest
@AutoConfigureMockMvc
class TestControllerIntegrationTest {

    private static final String URL = "/v1/tests";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnsStatus200() throws Exception {

        //Given
        List<Integer> list1 = Arrays.asList(2, 4, 6, 8);
        List<Integer> list2 = Arrays.asList(3, 7);
        ObjectLists objectLists = new ObjectLists(list1, list2);

        //When
        String requestBody = objectMapper.writeValueAsString(objectLists);

        //Then
        mockMvc.perform(post(URL).contentType("application/json").content(requestBody)).andExpect(status().isOk());
    }


    @Test
    void shouldReturnsStatus400_whenInvalidRequestBody() throws Exception {

        //Given
        List<Integer> list1 = Arrays.asList(2, 4, 6, 8);
        List<Integer> list2 = null;
        ObjectLists objectLists = new ObjectLists(list1, list2);

        //When
        String requestBody = objectMapper.writeValueAsString(objectLists);

        //Then
        mockMvc.perform(post(URL).contentType("application/json").content(requestBody)).andExpect(status().isBadRequest());
    }


}