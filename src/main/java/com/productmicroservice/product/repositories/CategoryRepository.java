package com.productmicroservice.product.repositories;

import com.productmicroservice.product.collection.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,Long> {
}
