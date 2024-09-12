package com.productmicroservice.product.repositories;

import com.productmicroservice.product.collection.Category;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category,String> {
    Optional<Category> findByName(@NotNull(message = "Category cannot be null") String name);
}
