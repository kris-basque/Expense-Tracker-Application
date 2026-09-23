

package com.example.Expense_Tracker.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.Expense_Tracker.model.Expense;
import com.example.Expense_Tracker.service.ExpenseService;
import com.example.Expense_Tracker.utils.ExpenseDataLoader;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController 
public class ExpenseController {

  private final ExpenseService expenseService;

  

  public ExpenseController(ExpenseService expenseService) {
    this.expenseService = expenseService;
  }

  @GetMapping("/expenses/day/{date}")
  public ResponseEntity<List<Expense>> getExpenseByDay(@PathVariable String date) {
    return ResponseEntity.ok(expenseService.getExpenseByDay(date));
  }
  

  @GetMapping("/expenses/categories")
  public ResponseEntity<List<String>> getAllExpenseCategories() {

    List<String> categories = expenseService.getAllExpensesCategories();

    if (categories.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    return ResponseEntity.ok(categories);       
  }

  @GetMapping("/expenses/{id}")
  public ResponseEntity<Optional<Expense>> getExpenseById(@PathVariable Long id) {

    return ResponseEntity.ok(expenseService.getExpenseById(id));
  }

  @PostMapping("/expenses")
  public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
    Expense newExpense = expenseService.addExpense(expense);
    return new ResponseEntity<>(newExpense, HttpStatus.CREATED);
  }

  @PutMapping("/expenses/{id}")
  public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
    expense.setId(id);
    boolean isUpdated = expenseService.updateExpense(expense);

    if (isUpdated) {
      return new ResponseEntity<>(expense, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
  }

  @DeleteMapping("/expenses/{id}")
  public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {

    boolean isDeleted = expenseService.deleteExpense(id);
    if (isDeleted) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  


  

  
} 



                // getExpenses() // Get all expenses
                // .stream() 
                // // This converts the list of expenses (List<Expense>) into a stream.
                //           // that allows you to perform a sequence Il of operations (like filtering, mapping,
                //           // reducing, etc.) on elements of a collection
                // .map     //The map operation is used to transform
                //         // elements in the stream. Here, it takes each Expense object and I transforms it 
                //         // by applying the getCategory method to each one.
                // (Expense::getCategory) // Expense:: getCategory is a method reference, which is shorthand for (expense) -> expense.getCategory
                // .distinct() // The distinct) operation removes duplicate elements / from the stream. It ensures that each category / appears only once in the resulting stream.
                // .toList(); 


