package com.example.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.model.Category;
import com.example.shop.model.Product;
import com.example.shop.service.CategoryService;
import com.example.shop.service.ProductService;

@RestController
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping
    public void createCategory(@RequestBody Category category) {
        categoryService.save(category);
    }

    @PutMapping("/{id}")
    public void updateCategory(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        categoryService.update(category);
    }

    @DeleteMapping
    public void deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
    }

    //
    @GetMapping("/{categoryId}/products")
    public List<Product> getProductsByCategoryId(@PathVariable Long categoryId) {
        return productService.findByCategoryId(categoryId);
    }
}
