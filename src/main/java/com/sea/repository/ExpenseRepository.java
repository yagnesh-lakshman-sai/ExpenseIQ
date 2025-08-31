package com.sea.repository;

import com.sea.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser_Id(Long userId);
    List<Expense> findByCategory_Id(Long categoryId);
}
