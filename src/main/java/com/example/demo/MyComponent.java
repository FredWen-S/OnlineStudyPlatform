package com.example.demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    @Value("${upload.path}")
    private String uploadPath;

    // 其他组件代码
}
