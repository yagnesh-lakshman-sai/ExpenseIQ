package com.sea.service;

import com.sea.dto.CategoryDTO;
import com.sea.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryDTO categoryDTO);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category updateCategory(Long id, CategoryDTO categoryDTO);
    void deleteCategory(Long id);
}
