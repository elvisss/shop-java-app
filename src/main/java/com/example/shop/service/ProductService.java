package com.example.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.dao.ProductDAO;
import com.example.shop.model.Product;

@Service
public class ProductService {
    
    @Autowired
    private ProductDAO productDao;

    public Product findById(Long id) {
        return productDao.findById(id);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void save(Product product) {
        productDao.save(product);
    }

    public void update(Product product) {
        productDao.update(product);
    }

    public void delete(Long id) {
        productDao.delete(id);
    }

    //
    public List<Product> findByCategoryId(Long categoryId) {
        return productDao.findByCategoryId(categoryId);
    }

    public List<Product> filterByQuery(String query) {
        return productDao.filterByQuery(query);
    }
}
