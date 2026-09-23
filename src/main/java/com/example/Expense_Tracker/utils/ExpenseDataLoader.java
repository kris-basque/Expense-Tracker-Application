

package com.example.Expense_Tracker.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.Expense_Tracker.model.Expense;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.PostConstruct;
import java.io.File;

@Component 
public class ExpenseDataLoader {

  private static List<Expense> expenses = new ArrayList<>();
  private static final String FILE_PATH = "src/main/resources/expenses.json";
  private static final ObjectMapper mapper = new ObjectMapper();

  @PostConstruct 
  public void init() {
    try {
      expenses = mapper.readValue(new File(FILE_PATH), new TypeReference<List<Expense>>(){});
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static List<Expense> getExpenses() {
    return expenses;
  }

  public static void saveToFile() {
    try {
      mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), expenses);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
