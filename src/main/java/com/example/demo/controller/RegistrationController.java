package com.example.demo.controller;

import com.example.demo.model.RegistrationRequest;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService; // 假设有一个 UserService 处理用户相关逻辑

    @PostMapping("/api/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        // 从 registrationRequest 中获取用户注册信息
        String username = registrationRequest.getUsername();
        String email = registrationRequest.getEmail();
        String role = registrationRequest.getRole();
        String department = registrationRequest.getDepartment();
        String major = registrationRequest.getMajor();

        // 这里进行注册逻辑，将用户信息存储到数据库中
        // 请注意，这里需要根据具体情况调用 UserService 或 UserRepository 进行用户信息存储

        // 假设调用 UserService 的方法进行用户注册，方法名为 registerUser
        userService.registerUser(username, email, role, department, major);

        return ResponseEntity.ok("Registration successful");
    }
}
