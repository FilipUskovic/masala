package com.budgetApp.restapi.controllers;

import com.budgetApp.restapi.model.Expenses;
import com.budgetApp.restapi.services.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {
    @Autowired
    private ExpensesService expensesService;

    @GetMapping("/getall")
    public ResponseEntity<List<Expenses>> getAllExpenses() {
        List<Expenses> expenses = expensesService.findAll();
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("getbyid/{id}")
    public ResponseEntity<Expenses> getExpensesById(@PathVariable Integer id) {
        Expenses expenses = expensesService.findById(id);
        if (expenses == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(expenses);
    }

    @PostMapping("crateExpenses/")
    public ResponseEntity<Expenses> createCategory(@RequestBody Expenses expenses) {
        Expenses savedExpenses = expensesService.save(expenses);
        return ResponseEntity.ok(savedExpenses);
    }

    @PutMapping("updateby/{id}")
    public ResponseEntity<Expenses> updateCategory(@PathVariable Integer id, @RequestBody Expenses expenses) {
        Expenses existingExpenses = expensesService.findById(id);
        if (existingExpenses == null) {
            return ResponseEntity.notFound().build();
        }
        existingExpenses.setCategory(expenses.getCategory());
        Expenses savedExpenses = expensesService.save(existingExpenses);
        return ResponseEntity.ok(savedExpenses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        Expenses existingExpenses = expensesService.findById(id);
        if (existingExpenses == null) {
            return ResponseEntity.notFound().build();
        }
        expensesService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
