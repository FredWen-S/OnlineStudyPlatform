package com.example.demo.controller;

import com.example.demo.model.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // 从 loginRequest 中获取用户名和密码
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // 处理登录逻辑，比如验证用户名和密码的正确性
        if ("valid_username".equals(username) && "valid_password".equals(password)) {
            return ResponseEntity.ok("Login successful"); // 登录成功
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials"); // 登录失败
        }
    }
}
