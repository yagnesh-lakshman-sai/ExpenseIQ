package com.sea.service;

import com.sea.dto.ExpenseDTO;
import com.sea.model.Expense;

import java.util.List;

public interface ExpenseService {
    Expense createExpense(ExpenseDTO expenseDTO);
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    Expense updateExpense(Long id, ExpenseDTO expenseDTO);
    void deleteExpense(Long id);
    List<Expense> getExpensesByUser(Long userId);
    List<Expense> getExpensesByCategory(Long categoryId);
}
