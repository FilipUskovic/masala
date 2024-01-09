package com.budgetApp.restapi.services;

import com.budgetApp.restapi.model.Category;
import com.budgetApp.restapi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createNewCategory(@RequestBody Category category){
        return null;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
}
