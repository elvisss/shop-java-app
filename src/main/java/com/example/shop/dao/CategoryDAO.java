package com.example.shop.dao;

import java.util.List;

import com.example.shop.model.Category;

public interface CategoryDAO {
    // findById, findAll, save, update, delete
    Category findById(Long Id);
    List<Category> findAll();
    void save(Category category);
    void update(Category category);
    void delete(Long id);
}
