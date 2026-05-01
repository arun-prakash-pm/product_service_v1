package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private String brand;

    private String category;

    private Double price;

    private Double discountPrice;

    private Integer stockQuantity;

    private String sku;

    private List<String> imageUrls;

    private Boolean active;

    private Double rating;

    private Integer reviewCount;

    private Map<String, String> attributes;
    // Example: {"color": "Red", "size": "M"}

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}