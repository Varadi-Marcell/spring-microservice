package com.example.productservice;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String id;
    private String name;
    private Integer price;
    private String description;
    private Category category;

    private Long restaurantId;

    public Product(String name, Integer price, String description, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public Product(String name, Integer price, String description, Category category, Long restaurantId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.restaurantId = restaurantId;
    }
}
