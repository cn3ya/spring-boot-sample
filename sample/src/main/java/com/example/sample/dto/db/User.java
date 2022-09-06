package com.example.sample.dto.db;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String email;
    private Integer age;
}
