package com.productmicroservice.product.services;

import com.productmicroservice.product.collection.Product;
import com.productmicroservice.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {


    @Autowired
    private ProductRepository productRepository;




    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
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

}
