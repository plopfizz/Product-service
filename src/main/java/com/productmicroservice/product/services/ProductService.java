package com.productmicroservice.product.services;

import com.productmicroservice.product.collection.Product;

import java.util.List;

public interface ProductService {


    Product createProduct(Product product);

    Product updateProduct(String id, Product product);

    void deleteProduct(String id);

    List<Product> getProducts(String category, String search);
}
