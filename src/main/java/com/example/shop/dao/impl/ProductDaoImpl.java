package com.example.shop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.shop.dao.ProductDAO;
import com.example.shop.model.Product;

@Repository
public class ProductDaoImpl implements ProductDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Product findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM product WHERE id = ?", new BeanPropertyRowMapper<>(Product.class), id);
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT * FROM product", new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public void save(Product product) {
        jdbcTemplate.update("INSERT INTO product (name, price, category_id) VALUES (?, ?, ?)",
                product.getName(), product.getPrice(), product.getCategoryId());
    }

    @Override
    public void update(Product product) {
        jdbcTemplate.update("UPDATE product SET name = ?, price = ?, category_id = ? WHERE id = ?",
                product.getName(), product.getPrice(), product.getCategoryId(), product.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM product WHERE id = ?", id);
    }

    @Override
    public List<Product> findByCategoryId(Long categoryId) {
        return jdbcTemplate.query("SELECT * FROM product WHERE category_id = ?", new BeanPropertyRowMapper<>(Product.class), categoryId);
    }

    @Override
    public List<Product> filterByQuery(String query) {
        return jdbcTemplate.query("SELECT * FROM product WHERE name LIKE ?", new BeanPropertyRowMapper<>(Product.class), "%" + query + "%");
    }
    
}
