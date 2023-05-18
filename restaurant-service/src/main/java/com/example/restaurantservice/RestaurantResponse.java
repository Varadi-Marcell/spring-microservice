package com.example.restaurantservice;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantResponse {
    private RestaurantDto restaurantDto;
    private List<Product> productList;
}
