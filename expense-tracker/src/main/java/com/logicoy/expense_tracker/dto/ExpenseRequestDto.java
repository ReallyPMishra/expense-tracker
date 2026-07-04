package com.logicoy.expense_tracker.dto;

import lombok.Data;

@Data
public class ExpenseRequestDto {

        private String title;
        private Double amount;
        private String description;
        private Long categoryId;
    }
