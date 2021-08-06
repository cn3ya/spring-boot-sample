package com.example.sample.controller;

import com.example.sample.dto.res.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @GetMapping(value="/error_test")
    public Response errorTest() {
        throw new RuntimeException("error test");
    }
}
