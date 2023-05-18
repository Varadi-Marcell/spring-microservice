package com.example.restaurantservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", url = "${application.config.product-url}" )
public interface ProductClient {
    @GetMapping("/with-restaurant/{restaurant-id}")
    List<Product> findAllProductsByRestaurantId(@PathVariable("restaurant-id") Long id);
    @DeleteMapping("/with-restaurant/{restaurant-id}")
    void deleteAllProductsByRestaurantId(@PathVariable("restaurant-id") Long id);
}
