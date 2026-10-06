

package com.example.Expense_Tracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.Expense_Tracker.model.Expense;
import com.example.Expense_Tracker.repository.ExpenseRepository;
import com.example.Expense_Tracker.utils.ExpenseDataLoader;

@Service 
@Profile("db") 
public class ExpenseServiceImplDb implements ExpenseService {

  private final ExpenseRepository expenseRepository;

  public ExpenseServiceImplDb(ExpenseRepository expenseRepository) {
    this.expenseRepository = expenseRepository;
  }

  @Override
  public List<Expense> getExpenseByDay(String date) {
    return expenseRepository.findAll().stream()
                            .filter(expense -> expense.getDate().equalsIgnoreCase(date))
                            .toList();
   
  }

  @Override
  public List<Expense> getExpenseByCategoryAndMonth(String category, String month) {
    return expenseRepository.findAll().stream()
                            .filter(expense -> expense.getCategory().equalsIgnoreCase(category) 
                            && expense.getDate().startsWith(month)).toList();
                            
  
  }

  @Override
  public List<String> getAllExpensesCategories() {
    return expenseRepository.findAll().stream().map(Expense::getCategory)
                        .distinct().toList();

  }

  @Override
  public Optional<Expense> getExpenseById(Long id) {
    return expenseRepository.findById(id);

  }

  @Override
  public Expense addExpense(Expense expense) {
    return expenseRepository.save(expense);
 
  }

  @Override
  public boolean updateExpense(Expense updateExpense) {
    if (expenseRepository.existsById(updateExpense.getId())) {
      expenseRepository.save(updateExpense);
      return true;
    }
    return false;

  }

  @Override
  public boolean deleteExpense(Long id) {
    if (expenseRepository.existsById(id)) {
      expenseRepository.deleteById(id);
      return true;
    }
    return false;

  }

}
