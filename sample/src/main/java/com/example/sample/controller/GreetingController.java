package com.example.sample.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.example.sample.dto.req.Greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, Haha is %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping(value="/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
