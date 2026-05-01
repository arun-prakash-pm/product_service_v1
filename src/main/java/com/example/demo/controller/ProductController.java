package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.createProduct(product);
    }

    // Get All
    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    // Get By ID
    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        return service.getProductById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Product update(@PathVariable String id,
                          @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.deleteProduct(id);
        return "Product deleted successfully";
    }
}