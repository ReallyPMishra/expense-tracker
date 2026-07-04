package com.logicoy.expense_tracker.dto;

import java.util.Map;

public class MonthlyReportDto {

    private int month;
    private int year;
    private Double totalExpense;
    private Long totalTransactions;
    private Map<String, Double> categoryWiseExpenses;

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Double getTotalExpense() {
        return totalExpense;
    }
    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
    }
    public Long getTotalTransactions() {
        return totalTransactions;
    }
    public void setTotalTransactions(Long totalTransactions) {
        this.totalTransactions = totalTransactions;
    }
    public Map<String, Double> getCategoryWiseExpenses() {
        return categoryWiseExpenses;
    }
    public void setCategoryWiseExpenses(Map<String, Double> categoryWiseExpenses) {
        this.categoryWiseExpenses = categoryWiseExpenses;
    }
}
