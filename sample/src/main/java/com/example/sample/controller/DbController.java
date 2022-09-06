package com.example.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.dto.db.User;
import com.example.sample.dto.res.Response;
import com.example.sample.mapper.UserMapper;

@RestController
@RequestMapping("/api/db")
public class DbController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value="/{id}")
	public Response path(@PathVariable int id) {
        User user = userMapper.selectById(id);
		return Response.ok(user);
	}
}
