package com.sea.controller;

import com.sea.dto.ExpenseDTO;
import com.sea.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenses;

    public ExpenseController(ExpenseService expenses) {
        this.expenses = expenses;
    }

    @PostMapping
    public ExpenseDTO create(@RequestBody ExpenseDTO dto) {
        return expenses.create(dto);
    }

    @GetMapping("/{id}")
    public ExpenseDTO get(@PathVariable Long id) {
        return expenses.getById(id);
    }

    @GetMapping
    public List<ExpenseDTO> list() {
        return expenses.getAll();
    }

    @PutMapping("/{id}")
    public ExpenseDTO update(@PathVariable Long id, @RequestBody ExpenseDTO dto) {
        return expenses.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        expenses.delete(id);
    }

    @GetMapping("/user/{userId}")
    public List<ExpenseDTO> listByUser(@PathVariable Long userId) {
        return expenses.getByUser(userId);
    }

    @GetMapping("/category/{categoryId}")
    public List<ExpenseDTO> listByCategory(@PathVariable Long categoryId) {
        return expenses.getByCategory(categoryId);
    }
}
