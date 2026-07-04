package com.logicoy.expense_tracker.service;

import com.logicoy.expense_tracker.dto.ExpenseRequestDto;
import com.logicoy.expense_tracker.dto.ExpenseResponseDto;
import com.logicoy.expense_tracker.entity.Category;
import com.logicoy.expense_tracker.entity.Expense;
import com.logicoy.expense_tracker.entity.User;
import com.logicoy.expense_tracker.repository.CategoryRepository;
import com.logicoy.expense_tracker.repository.ExpenseRepository;
import com.logicoy.expense_tracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    // Add Expense
    public ExpenseResponseDto addExpense(ExpenseRequestDto request) {

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() ->
                        new RuntimeException("Category not found"));

        // Get Logged-in User
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Expense expense = new Expense();

        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setDescription(request.getDescription());
        expense.setExpenseDate(LocalDate.now());
        expense.setCategory(category);
        expense.setUser(user);

        Expense savedExpense = expenseRepository.save(expense);

        return mapToResponse(savedExpense);
    }

    // Get All Expenses
    public List<ExpenseResponseDto> getAllExpenses() {

        return expenseRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Get Expense By Id
    public ExpenseResponseDto getExpenseById(Long id) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Expense not found"));

        return mapToResponse(expense);
    }

    // Update Expense
    public ExpenseResponseDto updateExpense(Long id,
                                            ExpenseRequestDto request) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Expense not found"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() ->
                        new RuntimeException("Category not found"));

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setDescription(request.getDescription());
        expense.setCategory(category);
        expense.setUser(user);

        Expense updatedExpense = expenseRepository.save(expense);

        return mapToResponse(updatedExpense);
    }

    // Delete Expense
    public void deleteExpense(Long id) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Expense not found"));

        expenseRepository.delete(expense);
    }

    // DTO Mapper
    private ExpenseResponseDto mapToResponse(Expense expense) {

        ExpenseResponseDto response = new ExpenseResponseDto();

        response.setId(expense.getId());
        response.setTitle(expense.getTitle());
        response.setAmount(expense.getAmount());
        response.setDescription(expense.getDescription());
        response.setExpenseDate(expense.getExpenseDate());

        if (expense.getCategory() != null) {
            response.setCategoryName(expense.getCategory().getName());
        }

        if (expense.getUser() != null) {
            response.setUserName(expense.getUser().getName());
        }

        return response;
    }
}
