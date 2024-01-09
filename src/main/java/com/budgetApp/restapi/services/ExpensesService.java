package com.budgetApp.restapi.services;

import com.budgetApp.restapi.model.Expenses;
import com.budgetApp.restapi.repositories.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService {
    @Autowired
    private ExpensesRepository expenseRepository;


    public List<Expenses> findAll() {
        return expenseRepository.findAll();
    }


    public Expenses findById(Integer id) {
        return expenseRepository.findById(id).orElse(null);
    }


    public Expenses save(Expenses expense) {
        return expenseRepository.save(expense);
    }


    public void deleteById(Integer id) {
        expenseRepository.deleteById(id);
    }
}
