package com.sea.service;

import com.sea.dto.ExpenseDTO;
import java.util.List;

public interface ExpenseService {
    ExpenseDTO create(ExpenseDTO dto);
    ExpenseDTO getById(Long id);
    List<ExpenseDTO> getAll();
    ExpenseDTO update(Long id, ExpenseDTO dto);
    void delete(Long id);

    List<ExpenseDTO> getByUser(Long userId);
    List<ExpenseDTO> getByCategory(Long categoryId);
}
