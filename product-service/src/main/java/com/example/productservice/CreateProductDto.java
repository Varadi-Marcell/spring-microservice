package com.example.productservice;

public record CreateProductDto(
        String name,
        Integer price,
        String description,
        Category category,
        Long restaurantId
) {
    public Product convertToEntity(CreateProductDto dto){
        return new Product(
                dto.name,
                dto.price,
                dto.description,
                dto.category,
                dto.restaurantId
        );
    }
}
