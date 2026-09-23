


package com.example.Expense_Tracker.service;

import java.util.List;
import java.util.Optional;

import com.example.Expense_Tracker.model.Expense;

public interface ExpenseService {


  List<Expense> getExpenseByDay(String Date);
  List<Expense> getExpenseByCategoryAndMonth(String category, String month);
  List<String> getAllExpensesCategories();

  Optional<Expense> getExpenseById(Long id);

  Expense addExpense(Expense expense);
  boolean updateExpense(Expense expense); 
  boolean deleteExpense(Long id);

}
