package com.example.sample.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.sample.dto.res.Response;

import lombok.SneakyThrows;


@RestController
@ControllerAdvice
public class ErrorController {

    @GetMapping(value="/error_test")
    public Response errorTest() {
        throw new RuntimeException("error test");
    }

    @SneakyThrows
    @ExceptionHandler(value=NoHandlerFoundException.class)
    public void handleException(HttpServletResponse response) {
        response.sendRedirect("/swagger-ui.html");
    }
}
