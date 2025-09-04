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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Expense createExpense(ExpenseDTO expenseDTO) {
        User user = userRepository.findById(expenseDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + expenseDTO.getUserId()));

        Category category = categoryRepository.findById(expenseDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + expenseDTO.getCategoryId()));

        Expense expense = Expense.builder()
                .description(expenseDTO.getDescription())
                .amount(expenseDTO.getAmount())
                .date(expenseDTO.getDate())
                .user(user)
                .category(category)
                .build();

        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
    }

    @Override
    public Expense updateExpense(Long id, ExpenseDTO expenseDTO) {
        Expense expense = getExpenseById(id);

        User user = userRepository.findById(expenseDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + expenseDTO.getUserId()));

        Category category = categoryRepository.findById(expenseDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + expenseDTO.getCategoryId()));

        expense.setDescription(expenseDTO.getDescription());
        expense.setAmount(expenseDTO.getAmount());
        expense.setDate(expenseDTO.getDate());
        expense.setUser(user);
        expense.setCategory(category);

        return expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = getExpenseById(id);
        expenseRepository.delete(expense);
    }

    @Override
    public List<Expense> getExpensesByUser(Long userId) {
        return expenseRepository.findAll()
                .stream()
                .filter(expense -> expense.getUser().getId().equals(userId))
                .toList();
    }

    @Override
    public List<Expense> getExpensesByCategory(Long categoryId) {
        return expenseRepository.findAll()
                .stream()
                .filter(expense -> expense.getCategory().getId().equals(categoryId))
                .toList();
    }
}
