package com.example.Expense_Tracker;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Expense_Tracker.model.Expense;
import com.example.Expense_Tracker.utils.ExpenseDataLoader;

@SpringBootApplication
public class ExpenseTrackerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

	@Override 
	public void run(String... args) throws Exception {
		List<Expense> expenseList = ExpenseDataLoader.getExpenses();
		expenseList.forEach(System.out::println);
	}

}
