package com.swithin.fooddeliveryservice.service;

import com.swithin.fooddeliveryservice.dto.RestaurantDTO;
import com.swithin.fooddeliveryservice.payload.RestaurantPayload;

import java.util.List;

public interface RestaurantService {
    RestaurantDTO addRestaurant(RestaurantPayload payload, String token);
    List<RestaurantDTO> getRestaurants();
    RestaurantDTO getRestaurantById(Long id);
    RestaurantDTO updateRestaurant(Long id, RestaurantPayload payload, String token);
}
