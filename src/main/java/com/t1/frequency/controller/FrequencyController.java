package com.t1.frequency.controller;

import com.t1.frequency.service.FrequencyCalculator;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@OpenAPIDefinition(info = @Info(title = "Frequency Analyzer API", description =
        "Character Frequency Analyzer API is a RESTful web service designed to calculate the frequency of occurrence " +
                "of characters in a given string. The API allows users to send a string in a request and receive " +
                "a JSON object in response with a sorted list of characters and the number of their occurrences " +
                "in a given string", version = "1.0"
))
@RestController("/api/v1/")
public class FrequencyController {

    @Autowired
    private FrequencyCalculator frequencyCalculator;

    @Operation(summary = "Get a frequency of each character in given line")
    @ApiResponse(
            responseCode = "200",
            description = "Success",
            content = @Content(examples = {
                    @ExampleObject(
                            """
                                    {
                                      "a": 5,
                                      "b": 3,
                                      "c": 4,
                                      "d": 2
                                    }
                            """
                    )
            })
    )
    @GetMapping(value = "/calculate-frequency", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Character, Integer> calculateFrequency(
            @RequestParam("input") @Parameter(description = "input line") String input
    ) {
        return frequencyCalculator.calculateFrequency(input);
    }

}