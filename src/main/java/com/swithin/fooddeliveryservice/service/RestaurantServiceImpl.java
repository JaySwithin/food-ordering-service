package com.swithin.fooddeliveryservice.service;

import com.swithin.fooddeliveryservice.config.EntityMapper;
import com.swithin.fooddeliveryservice.dto.RestaurantDTO;
import com.swithin.fooddeliveryservice.entity.Restaurant;
import com.swithin.fooddeliveryservice.errors.AuthException;
import com.swithin.fooddeliveryservice.errors.RestaurantNotFoundException;
import com.swithin.fooddeliveryservice.payload.RestaurantPayload;
import com.swithin.fooddeliveryservice.repository.RestaurantRepository;
import com.swithin.fooddeliveryservice.repository.UserSessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final UserSessionRepository userSessionRepository;
    private final EntityMapper mapper;
    @Override
    public RestaurantDTO addRestaurant(RestaurantPayload payload, String token) {
        userSessionRepository.findByUUID(token).orElseThrow(() ->
                new AuthException("Unauthorized. User not logged in."));
        Restaurant restaurant = Restaurant
                .builder()
                .restaurantName(payload.getRestaurantName())
                .restaurantEmail(payload.getRestaurantEmail())
                .phoneNumber(payload.getPhoneNumber())
                .restaurantAddress(payload.getRestaurantAddress())
                .build();

        var res = restaurantRepository.save(restaurant);
        return mapper.restaurantToDto(res);
    }

    @Override
    public List<RestaurantDTO> getRestaurants() {
        var restaurants = restaurantRepository.findAll();
        return restaurants.stream()
                .map(mapper::restaurantToDto).
                collect(Collectors.toList());
    }

    @Override
    public RestaurantDTO getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() ->
                new RestaurantNotFoundException("Restaurant not found"));
        return mapper.restaurantToDto(restaurant);
    }

    @Override
    public RestaurantDTO updateRestaurant(Long id, RestaurantPayload payload, String token) {
        userSessionRepository.findByUUID(token).orElseThrow(() ->
                new AuthException("Unauthorized. User not logged in."));
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() ->
                new RestaurantNotFoundException("Restaurant not found"));
        mapper.updateFields(restaurant, payload);
        var res = restaurantRepository.save(restaurant);
        return mapper.restaurantToDto(res);
    }
}
