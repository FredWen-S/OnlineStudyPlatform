package com.example.demo.repository;


import com.example.demo.model.MyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyClassRepository extends JpaRepository<MyClass, Long> {
    // 可以添加自定义的查询方法
}
