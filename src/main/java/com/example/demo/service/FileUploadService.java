package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadService {

    private final FileStorage fileStorage;

    @Autowired
    public FileUploadService(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }

    public void uploadFile(MultipartFile file) throws IOException {
        fileStorage.storeFile(file); // 调用 FileStorage 类的方法存储文件
        // 进行其他的文件上传逻辑或处理
    }
}
