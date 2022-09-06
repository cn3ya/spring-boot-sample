package com.example.sample.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sample.dto.db.User;

@Mapper
public interface UserMapper extends BaseMapper<User>{
    
}
