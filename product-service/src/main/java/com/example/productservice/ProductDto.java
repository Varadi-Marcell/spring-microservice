package com.example.productservice;

public record ProductDto(
        String name,
        Integer price,
        String description,
        Category category,
        Long id
) {

    public Product dtoToProduct(ProductDto dto){
        return new Product(
                dto.name,
                dto.price,
                dto.description,
                dto.category,
                dto.id
        );
    }
}
