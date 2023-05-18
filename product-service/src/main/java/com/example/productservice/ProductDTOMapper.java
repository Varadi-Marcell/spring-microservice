package com.example.productservice;

import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class ProductDTOMapper implements Function<Product, ProductDto> {
    @Override
    public ProductDto apply(Product product) {
        return new ProductDto(
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getCategory(),
                product.getRestaurantId()
        );
    }
}
