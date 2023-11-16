package com.example.demo.service;

public interface UserService {
    void registerUser(String username, String email, String role, String department, String major);

    void updateUser(Long userId, String username, String password, String role, String department, String major);

    void deleteUser(Long userId);
    // 其他可能的方法
}
