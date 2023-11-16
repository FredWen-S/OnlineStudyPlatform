package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    @Value("${upload.path}")
    private String uploadPath; // 设置上传文件的路径，可以在 application.properties 中配置

    @PostMapping("/api/upload")
    public ResponseEntity<String> handleFileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("description") String description
    ) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload");
        }

        try {
            // 设置文件存储路径
            String filePath = uploadPath + File.separator + file.getOriginalFilename();
            File dest = new File(filePath);
            file.transferTo(dest); // 将文件保存到指定路径

            // 在这里可以将文件相关信息（如标题、描述等）存储到数据库或者进行其他操作

            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload file: " + e.getMessage());
        }
    }
}
