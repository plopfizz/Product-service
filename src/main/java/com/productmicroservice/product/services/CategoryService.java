package com.productmicroservice.product.services;

import com.productmicroservice.product.collection.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    Category updateCategory(String id, Category category);

    void deleteCategory(String id);

    List<Category> getAllCategories();
}
