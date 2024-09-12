package com.productmicroservice.product.controllers;

import com.productmicroservice.product.collection.Product;
import com.productmicroservice.product.collection.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.productmicroservice.product.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/category/{categoryId}")
    public List<Product> filterProductsByCategory(@PathVariable String categoryId) {

        return productService.filterProductsByCategory(categoryId);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String search

    ) {
        return ResponseEntity.ok(productService.getProducts(category, search));
    }
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name) {
        return productService.searchProducts(name.trim());
    }
    @GetMapping("/{productId}/reviews")
    public List<Review> getReviewsForProduct(@PathVariable String productId) {
        return productService.getReviewsForProduct(productId);
    }
    @PostMapping("/{productId}/reviews")
    public Review addReviewToProduct(@PathVariable String productId, @RequestBody Review review) {
        return productService.addReview(productId, review);
    }
}
