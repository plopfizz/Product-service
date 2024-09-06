package com.productmicroservice.product.repositories;

import com.productmicroservice.product.collection.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {
    List<Product> findByCategory(String category);
}
