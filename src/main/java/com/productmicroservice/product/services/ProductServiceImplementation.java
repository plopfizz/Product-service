package com.productmicroservice.product.services;

import com.productmicroservice.product.collection.Product;
import com.productmicroservice.product.collection.Review;
import com.productmicroservice.product.repositories.CategoryRepository;
import com.productmicroservice.product.repositories.ProductRepository;
import com.productmicroservice.product.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ReviewRepository reviewRepository;



    @Override
    public Product createProduct(Product product) {
        categoryRepository.findById(product.getCategory().getId()).orElseThrow(() ->
                new RuntimeException("Category not found"));
        return productRepository.save(product);

    }

    @Override
    public Product updateProduct(String id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        }
        throw new RuntimeException("Product not found");
    }

    public void deleteProduct(String id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
    }

    @Override
    public List<Product> getProducts(String category, String search) {
        if (category != null) {
            return productRepository.findByCategory(category);
        }
        return productRepository.findAll();

    }
    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }
    @Override
    public List<Product> searchProducts(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Review> getReviewsForProduct(String productId) {
        return reviewRepository.findByProductId(productId);
    }
    public Review addReview(String productId, Review review) {
        productRepository.findById(productId).orElseThrow(() ->
                new RuntimeException("Product not found"));

        review.setProductId(productId);
        review = reviewRepository.save(review);

        updateProductRating(productId);
        return review;
    }

    @Override
    public List<Product> filterProductsByCategory(String categoryId) {
        System.out.println("categoryId"+categoryId);
        return productRepository.findByCategoryId(categoryId);
    }

    private void updateProductRating(String productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId) ;
        double averageRating =reviews.isEmpty() ? 0.0: reviews.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);

        Product product = productRepository.findById(productId).get();
        product.setAverageRating(averageRating);
        product.setTotalReviews(reviews.size());
        productRepository.save(product);
    }


}
