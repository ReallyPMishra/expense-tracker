package com.logicoy.expense_tracker.service;

import com.logicoy.expense_tracker.dto.MonthlyReportDto;
import com.logicoy.expense_tracker.entity.Expense;
import com.logicoy.expense_tracker.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ExpenseRepository expenseRepository;
    public MonthlyReportDto getMonthlyReport(int month, int year) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        List<Expense> expenses =
                expenseRepository.findByExpenseDateBetween(startDate, endDate);
        double totalExpense = expenses.stream().mapToDouble(Expense::getAmount).sum();
        Map<String, Double> categoryWiseExpenses = new HashMap<>();
        for (Expense expense : expenses) {
            if (expense.getCategory() != null) {

                String categoryName = expense.getCategory().getName();
                categoryWiseExpenses.put(
                        categoryName,
                        categoryWiseExpenses.getOrDefault(categoryName, 0.0)
                                + expense.getAmount());
            }
        }
        MonthlyReportDto report = new MonthlyReportDto();
        report.setMonth(month);
        report.setYear(year);
        report.setTotalExpense(totalExpense);
        report.setTotalTransactions((long) expenses.size());
        report.setCategoryWiseExpenses(categoryWiseExpenses);
        return report;
    }
}