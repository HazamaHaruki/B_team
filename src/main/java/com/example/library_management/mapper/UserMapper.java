package com.example.library_management.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.library_management.entity.User;

@Mapper
public interface UserMapper {
    @Select("SELECT user_id, username, password, created_at FROM LogIn WHERE username = #{username}")
    User selectUserByUsername(String username);

    @Insert("INSERT INTO LogIn (username, password) VALUES (#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void insertUser(User user);
}