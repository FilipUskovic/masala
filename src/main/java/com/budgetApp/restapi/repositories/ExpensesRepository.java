package com.budgetApp.restapi.repositories;

import com.budgetApp.restapi.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Integer> {

}
