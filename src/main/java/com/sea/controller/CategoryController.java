package com.sea.controller;

import com.sea.dto.CategoryDTO;
import com.sea.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categories;

    public CategoryController(CategoryService categories) {
        this.categories = categories;
    }

    @PostMapping
    public CategoryDTO create(@RequestBody CategoryDTO dto) {
        return categories.create(dto);
    }

    @GetMapping("/{id}")
    public CategoryDTO get(@PathVariable Long id) {
        return categories.getById(id);
    }

    @GetMapping
    public List<CategoryDTO> list() {
        return categories.getAll();
    }

    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable Long id, @RequestBody CategoryDTO dto) {
        return categories.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categories.delete(id);
    }
}
