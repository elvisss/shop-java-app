package com.example.shop.dao.impl;

import com.example.shop.dao.CategoryDAO;
import com.example.shop.model.Category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl implements CategoryDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // public CategoryDaoImpl() {
    //     this.jdbcTemplate = new JdbcTemplate()
    // }

    private final RowMapper<Category> rowMapper = (rs, rowNum) -> {
        Category category = new Category();
        category.setId(rs.getLong("id"));
        category.setName(rs.getString("name"));
        return category;
    };

    @Override
    public Category findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM category WHERE id = ?", rowMapper, id);
    }

    @Override
    public List<Category> findAll() {
        return jdbcTemplate.query("SELECT * FROM category", rowMapper);
    }

    @Override
    public void save(Category category) {
        jdbcTemplate.update("INSERT INTO category (name) VALUES (?)", category.getName());
    }

    @Override
    public void update(Category category) {
        jdbcTemplate.update("UPDATE category SET name = ? WHERE id = ?", category.getName(), category.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM category WHERE id = ?", id);
    }
}
