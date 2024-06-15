package com.example.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.dao.CategoryDAO;
import com.example.shop.model.Category;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryDAO categoryDAO;

    public Category findById(Long id) {
        return categoryDAO.findById(id);
    }

    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    public void save(Category category) {
        categoryDAO.save((category));
    }

    public void update(Category category) {
        categoryDAO.update(category);
    }

    public void delete(Long id) {
        categoryDAO.delete(id);
    }
}
