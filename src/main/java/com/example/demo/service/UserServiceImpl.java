package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(String username, String password, String role, String department, String major) {
        // 在这里创建 User 对象，并使用合适的构造函数
        User user = new User(username, password, role, department, major);
        userRepository.save(user);
    }


    @Override
    public void updateUser(Long userId, String username, String password, String role, String department, String major) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(UserRole.valueOf(role));
            user.setDepartment(department);
            user.setMajor(major);
            userRepository.save(user);
        } else {
            // 处理用户不存在的情况，这里选择抛出异常
            throw new RuntimeException("User not found with ID: " + userId);
            // 或者执行其他逻辑处理
        }
    }


    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    // 其他可能的方法的实现
}
