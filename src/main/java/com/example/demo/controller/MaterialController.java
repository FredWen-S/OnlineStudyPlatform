package com.example.demo.controller;

import com.example.demo.model.Material;
import com.example.demo.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/list")
    public List<Material> getMaterials() {
        return materialService.getAllMaterials(); // 获取所有材料数据
    }

    @PostMapping("/upload")
    public Material uploadMaterial(@RequestBody Material material) {
        return materialService.uploadMaterial(material); // 上传材料
    }

    @PutMapping("/edit/{id}")
    public Material editMaterial(@PathVariable Long id, @RequestBody Material updatedMaterial) {
        return materialService.editMaterial(id, updatedMaterial); // 编辑材料
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMaterial(@PathVariable Long id) {
        materialService.deleteMaterial(id); // 删除材料
    }
}
