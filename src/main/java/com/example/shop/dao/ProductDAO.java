package com.example.shop.dao;

import java.util.List;

import com.example.shop.model.Product;

public interface ProductDAO {
    Product findById(Long id);
    List<Product> findAll();
    void save(Product product);
    void update(Product product);
    void delete(Long id);
    //
    List<Product> findByCategoryId(Long categoryId);
    List <Product> filterByQuery(String query);
}
