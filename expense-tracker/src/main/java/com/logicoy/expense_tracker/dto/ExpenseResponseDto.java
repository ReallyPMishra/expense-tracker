package com.logicoy.expense_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponseDto {

    private Long id;
    private String title;
    private Double amount;
    private String description;
    private LocalDate expenseDate;
    private String categoryName;
    private String userName;
}
