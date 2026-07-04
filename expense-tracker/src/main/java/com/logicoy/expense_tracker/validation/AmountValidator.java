package com.logicoy.expense_tracker.validation;

public class AmountValidator {

    private AmountValidator() {
    }

    public static boolean isValid(Double amount) {
        return amount != null && amount > 0;
    }
}
