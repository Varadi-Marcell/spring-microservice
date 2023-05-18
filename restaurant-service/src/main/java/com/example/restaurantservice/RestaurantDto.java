package com.example.restaurantservice;

public record RestaurantDto(
        Long id,
        String name,
        String email,
        String address,
        String phoneNumber,
        double rate
) {
    public Restaurant convertToEntity(RestaurantDto dto){
        return new Restaurant(
                dto.name,
                dto.email,
                dto.address,
                dto.phoneNumber,
                dto.rate
        );
    }
}
