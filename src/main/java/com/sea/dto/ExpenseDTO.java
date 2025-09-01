package com.sea.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseDTO {
	private Long id;
	private String description;
	private Double amount;
	private LocalDate date;
	private Long userId;
	private Long categoryId;	
}
