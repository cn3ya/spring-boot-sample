package com.example.sample.controller;

import com.example.sample.dto.req.GetReq;
import com.example.sample.dto.res.Response;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/param")
public class ParamController {

    @GetMapping(value="/get")
	public Response get(GetReq getReq) {
		return Response.ok(getReq.getName());
	}

	@PostMapping(value="/post")
	public Response post(@RequestBody GetReq getReq) {
		return Response.ok(getReq);
	}

	@GetMapping(value="/path/{id}")
	public Response path(@PathVariable int id) {
		return Response.ok(id);
	}
}
