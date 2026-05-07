package com.sea.dto;

import lombok.*;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseDTO {
	private Long id;
	@NotBlank
	private String description;

	@Positive
	private Double amount;

	@NotNull
	private LocalDate date;
	private Long userId;
	private Long categoryId;	
}
