package com.sea.service.impl;

import com.sea.dto.ExpenseDTO;
import com.sea.exception.ResourceNotFoundException;
import com.sea.model.Category;
import com.sea.model.Expense;
import com.sea.model.User;
import com.sea.repository.CategoryRepository;
import com.sea.repository.ExpenseRepository;
import com.sea.repository.UserRepository;
import com.sea.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenses;
    private final UserRepository users;
    private final CategoryRepository categories;

    public ExpenseServiceImpl(ExpenseRepository expenses, UserRepository users, CategoryRepository categories) {
        this.expenses = expenses;
        this.users = users;
        this.categories = categories;
    }

    @Override
    public ExpenseDTO create(ExpenseDTO dto) {
        Expense e = toEntity(dto);
        e = expenses.save(e);
        return toDTO(e);
    }

    @Override
    public ExpenseDTO getById(Long id) {
        Expense e = expenses.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found: " + id));
        return toDTO(e);
    }

    @Override
    public List<ExpenseDTO> getAll() {
        return expenses.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ExpenseDTO update(Long id, ExpenseDTO dto) {
        Expense e = expenses.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found: " + id));

        if (dto.getDescription() != null) e.setDescription(dto.getDescription());
        if (dto.getAmount() != null) e.setAmount(dto.getAmount());
        if (dto.getDate() != null) e.setDate(dto.getDate());
        if (dto.getUserId() != null) {
            User u = users.findById(dto.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found: " + dto.getUserId()));
            e.setUser(u);
        }
        if (dto.getCategoryId() != null) {
            Category c = categories.findById(dto.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found: " + dto.getCategoryId()));
            e.setCategory(c);
        }

        return toDTO(expenses.save(e));
    }

    @Override
    public void delete(Long id) {
        if (!expenses.existsById(id)) throw new ResourceNotFoundException("Expense not found: " + id);
        expenses.deleteById(id);
    }

    @Override
    public List<ExpenseDTO> getByUser(Long userId) {
        return expenses.findByUser_Id(userId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ExpenseDTO> getByCategory(Long categoryId) {
        return expenses.findByCategory_Id(categoryId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    private Expense toEntity(ExpenseDTO dto) {
        if (dto.getUserId() == null || dto.getCategoryId() == null)
            throw new IllegalArgumentException("userId and categoryId are required");

        User u = users.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + dto.getUserId()));
        Category c = categories.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found: " + dto.getCategoryId()));

        return Expense.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .amount(dto.getAmount())
                .date(dto.getDate())
                .user(u)
                .category(c)
                .build();
    }

    private ExpenseDTO toDTO(Expense e) {
        return ExpenseDTO.builder()
                .id(e.getId())
                .description(e.getDescription())
                .amount(e.getAmount())
                .date(e.getDate())
                .userId(e.getUser().getId())
                .categoryId(e.getCategory().getId())
                .build();
    }
}
