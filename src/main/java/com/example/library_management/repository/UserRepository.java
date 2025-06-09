package com.example.library_management.repository;

import org.springframework.stereotype.Repository;

import com.example.library_management.entity.User;
import com.example.library_management.mapper.UserMapper;

@Repository
public class UserRepository {
    private final UserMapper userMapper;
    public UserRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}