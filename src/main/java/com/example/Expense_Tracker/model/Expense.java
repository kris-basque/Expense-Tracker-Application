

package com.example.Expense_Tracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data 
public class Expense {


  @JsonProperty("id") 
  private Long id;

  @JsonProperty("expenseType") 
  private int expenseType;

  @JsonProperty("date") 
  private String date;

  @JsonProperty("amount") 
  private double amount;

  @JsonProperty("account") 
  private String account;

  @JsonProperty("note") 
  private String note;

  @JsonProperty("category") 
  private String category;


}
