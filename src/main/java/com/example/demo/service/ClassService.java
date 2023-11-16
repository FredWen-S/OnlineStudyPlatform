package com.example.demo.service;


import com.example.demo.model.MyClass;
import com.example.demo.repository.MyClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    private final MyClassRepository classRepository;

    @Autowired
    public ClassService(MyClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<MyClass> getAllClasses() {
        return classRepository.findAll();
    }

    public MyClass createClass(MyClass myClass) {
        return classRepository.save(myClass);
    }

    public MyClass editClass(Long id, MyClass updatedClass) {
        Optional<MyClass> optionalClass = classRepository.findById(id);
        if (optionalClass.isPresent()) {
            MyClass existingClass = optionalClass.get();
            existingClass.setClassName(updatedClass.getClassName());
            existingClass.setTeacher(updatedClass.getTeacher());
            return classRepository.save(existingClass);
        } else {
            throw new RuntimeException("Class not found with id: " + id);
        }
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}