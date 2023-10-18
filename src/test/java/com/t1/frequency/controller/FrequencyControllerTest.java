package com.t1.frequency.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class FrequencyControllerTest {

    private static final String URL = "/api/v1/calculate-frequency?input=";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenMultipleCharactersInARow() throws Exception {
        String input = "aaaaabcccc";
        MvcResult result = this.mockMvc.perform(get(URL + input))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"a\":5,\"b\":1,\"c\":4}"))
                .andReturn();
        result.getResponse().getContentAsString();
    }

    @Test
    public void whenEmptyString() throws Exception {
        String input = "";
        MvcResult result = this.mockMvc.perform(get(URL + input))
                .andExpect(status().isOk())
                .andExpect(content().string("{}"))
                .andReturn();
        result.getResponse().getContentAsString();
    }

    @Test
    public void whenOneCharacter() throws Exception {
        String input = "a";
        MvcResult result = this.mockMvc.perform(get(URL + input))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"a\":1}"))
                .andReturn();
        result.getResponse().getContentAsString();
    }

    @Test
    public void whenCharactersAlternate() throws Exception {
        String input = "aaccaa";
        MvcResult result = this.mockMvc.perform(get(URL + input))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"a\":4,\"c\":2}"))
                .andReturn();
        result.getResponse().getContentAsString();
    }


    @Test
    public void whenSingleCharacters() throws Exception {
        String input = "abcdef";
        MvcResult result = this.mockMvc.perform(get(URL + input))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"a\":1,\"b\":1,\"c\":1,\"d\":1,\"e\":1,\"f\":1}"))
                .andReturn();
        result.getResponse().getContentAsString();
    }

    @Test
    public void whenOneCharacterIsRepeated() throws Exception {
        String input = "aaaaaa";
        MvcResult result = this.mockMvc.perform(get(URL + input))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"a\":6}"))
                .andReturn();
        result.getResponse().getContentAsString();
    }
}

