package com.sea.service.impl;

import com.sea.dto.CategoryDTO;
import com.sea.exception.ResourceNotFoundException;
import com.sea.model.Category;
import com.sea.repository.CategoryRepository;
import com.sea.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categories;

    public CategoryServiceImpl(CategoryRepository categories) {
        this.categories = categories;
    }

    @Override
    public CategoryDTO create(CategoryDTO dto) {
        if (dto.getName() == null || dto.getName().isBlank())
            throw new IllegalArgumentException("Category name is required");

        if (categories.existsByName(dto.getName()))
            throw new IllegalArgumentException("Category already exists: " + dto.getName());

        Category c = Category.builder().name(dto.getName()).build();
        c = categories.save(c);
        return toDTO(c);
    }

    @Override
    public CategoryDTO getById(Long id) {
        Category c = categories.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found: " + id));
        return toDTO(c);
    }

    @Override
    public List<CategoryDTO> getAll() {
        return categories.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO dto) {
        Category c = categories.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found: " + id));
        if (dto.getName() != null && !dto.getName().isBlank()) c.setName(dto.getName());
        return toDTO(categories.save(c));
    }

    @Override
    public void delete(Long id) {
        if (!categories.existsById(id)) throw new ResourceNotFoundException("Category not found: " + id);
        categories.deleteById(id);
    }

    private CategoryDTO toDTO(Category c) {
        return CategoryDTO.builder().id(c.getId()).name(c.getName()).build();
    }
}
