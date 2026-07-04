package com.logicoy.expense_tracker.util;

public class AppConstants {

    private AppConstants() {
    }
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String API_VERSION = "/api/v1";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String USER_NOT_FOUND = "User not found";
    public static final String EXPENSE_NOT_FOUND = "Expense not found";
    public static final String CATEGORY_NOT_FOUND = "Category not found";
    public static final String USER_REGISTERED = "User registered successfully";
    public static final String EXPENSE_DELETED = "Expense deleted successfully";
    public static final double MIN_EXPENSE_AMOUNT = 0.0;
}