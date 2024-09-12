package com.productmicroservice.product.services;

import com.productmicroservice.product.collection.Product;
import com.productmicroservice.product.collection.Review;

import java.util.List;
import java.util.Optional;

public interface ProductService {


    Product createProduct(Product product);

    Product updateProduct(String id, Product product);

    void deleteProduct(String id);

    List<Product> getProducts(String category, String search);

    Optional<Product> getProductById(String id);

    List<Product> searchProducts(String name);

    List<Review> getReviewsForProduct(String productId);

    Review addReview(String productId, Review review);

    List<Product> filterProductsByCategory(String categoryId);
}
