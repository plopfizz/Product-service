package com.productmicroservice.product.repositories;

import com.productmicroservice.product.collection.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository  extends MongoRepository<Review,Long> {
    List<Review> findByProductId(String productId);
}

