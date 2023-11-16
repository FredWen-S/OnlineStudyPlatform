package com.example.demo.controller;

import com.example.demo.model.MyClass;
import com.example.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/list")
    public List<MyClass> getClassList() {
        return classService.getAllClasses();
    }

    @PostMapping("/create")
    public MyClass createClass(@RequestBody MyClass myClass) {
        return classService.createClass(myClass);
    }

    @PutMapping("/edit/{id}")
    public MyClass editClass(@PathVariable Long id, @RequestBody MyClass updatedClass) {
        return classService.editClass(id, updatedClass);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
    }
}
