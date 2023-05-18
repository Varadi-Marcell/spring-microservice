package com.example.restaurantservice;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant")
@AllArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants(){
        return new ResponseEntity<>(restaurantService.getAllRestaurant(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> createRestaurant(@RequestBody CreateRestaurantDto dto){
        restaurantService.createRestaurant(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRestaurantById(@PathVariable("id")Long id){
        restaurantService.deleteRestaurantById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("{id}")
    public ResponseEntity<RestaurantResponse> getRestaurantById(@PathVariable("id") Long id){
        return new ResponseEntity<>(restaurantService.getRestaurantById(id),HttpStatus.OK);
    }
}
