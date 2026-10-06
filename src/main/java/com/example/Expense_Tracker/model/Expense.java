

package com.example.Expense_Tracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity 
@Data 
public class Expense {

  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int expenseType;
  private String date;
  private double amount;
  private String account;
  private String note;
  private String category;


}



// Set up this Neon project in the current working directory.

// 1. `npm i -g neon@latest && neon login`
// 2. `neon skills -y`
// 3. `neon mcp -y`
// 4. `neon link --project-id winter-truth-70477011 --branch production -y`
// 5. `neon config init`
// 6. Update `neon.ts`:

// ```ts
// import { defineConfig } from "@neon/config/v1";

// export default defineConfig({});
// ```

// 7. `neon deploy`