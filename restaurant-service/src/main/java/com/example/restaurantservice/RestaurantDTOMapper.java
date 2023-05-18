package com.example.restaurantservice;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class RestaurantDTOMapper implements Function<Restaurant,RestaurantDto> {
    @Override
    public RestaurantDto apply(Restaurant restaurant) {
        return new RestaurantDto(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getEmail(),
                restaurant.getAddress(),
                restaurant.getPhoneNumber(),
                restaurant.getRate()
        );
    }
}
