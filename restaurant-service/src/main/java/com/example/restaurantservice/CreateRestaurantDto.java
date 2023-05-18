package com.example.restaurantservice;

public record CreateRestaurantDto(
        String name,
        String email,
        String address,
        String phoneNumber
    ) {
    public Restaurant convertToEntity(CreateRestaurantDto dto){
        return new Restaurant(
                dto.name,
                dto.email,
                dto.address,
                dto.phoneNumber
        );
    }
}
