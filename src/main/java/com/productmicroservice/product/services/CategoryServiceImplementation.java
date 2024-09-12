package com.productmicroservice.product.services;

import com.productmicroservice.product.collection.Category;
import com.productmicroservice.product.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplementation  implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    public Category createCategory(Category category) {
        Optional<Category> existingCategory = categoryRepository.findByName(category.getName());
        return existingCategory.orElseGet(() -> categoryRepository.save(category));
    }

    public Category updateCategory(String id, @org.jetbrains.annotations.NotNull Category category) {
        category.setId((id));
        return categoryRepository.save(category);
    }

    public void deleteCategory(String id) {
        categoryRepository.deleteById((id));
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
