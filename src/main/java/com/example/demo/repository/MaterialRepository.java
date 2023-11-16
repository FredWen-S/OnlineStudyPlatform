package com.example.demo.repository;

import com.example.demo.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    // 可以添加自定义的查询方法
}
