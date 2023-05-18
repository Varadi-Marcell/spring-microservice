package com.example.restaurantservice;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final ProductClient productClient;
    private final RestaurantDTOMapper mapper;

    public List<RestaurantDto> getAllRestaurant() {
        return restaurantRepository.findAll()
                .stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    @Transactional
    public RestaurantResponse getRestaurantById(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        var productList = productClient.findAllProductsByRestaurantId(id);

        if (restaurant.isEmpty()) {
            throw new RuntimeException("restaurant not found!");
        }

        return RestaurantResponse.builder()
                .restaurantDto(mapper.apply(restaurant.get()))
                .productList(productList)
                .build();
    }

    public void createRestaurant(CreateRestaurantDto dto) {
        restaurantRepository.save(dto.convertToEntity(dto));
    }

    public void deleteRestaurantById(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if (restaurant.isEmpty()) {
            throw new RuntimeException("restaurant not found!");
        }

        productClient.deleteAllProductsByRestaurantId(id);
        restaurantRepository.deleteById(id);

    }

}
