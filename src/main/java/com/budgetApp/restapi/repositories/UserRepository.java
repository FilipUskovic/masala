package com.budgetApp.restapi.repositories;

import java.util.List;
import java.util.Optional;

import com.budgetApp.restapi.model.Category;
import com.budgetApp.restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);
  @Override
  Optional<User> findById(Integer id);

  @Override
  List<User> findAll();
}
