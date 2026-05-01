package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    // Create Product
    public Product createProduct(Product product) {
//        product.setCreatedAt(LocalDateTime.now());
//        product.setUpdatedAt(LocalDateTime.now());
//        product.setActive(true);
        return repository.save(product);
    }

    // Get All Products
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // Get Product By ID
    public Product getProductById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    // Update Product
    public Product updateProduct(String id, Product updatedProduct) {
        Product existing = getProductById(id);

//        existing.setName(updatedProduct.getName());
//        existing.setDescription(updatedProduct.getDescription());
//        existing.setBrand(updatedProduct.getBrand());
//        existing.setCategory(updatedProduct.getCategory());
//        existing.setPrice(updatedProduct.getPrice());
//        existing.setDiscountPrice(updatedProduct.getDiscountPrice());
//        existing.setStockQuantity(updatedProduct.getStockQuantity());
//        existing.setImageUrls(updatedProduct.getImageUrls());
//        existing.setAttributes(updatedProduct.getAttributes());
//        existing.setUpdatedAt(LocalDateTime.now());

        return repository.save(existing);
    }

    // Delete Product
    public void deleteProduct(String id) {
        repository.deleteById(id);
    }
}