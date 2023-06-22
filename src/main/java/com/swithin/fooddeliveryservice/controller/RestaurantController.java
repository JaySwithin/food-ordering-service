package com.swithin.fooddeliveryservice.controller;

import com.swithin.fooddeliveryservice.dto.RestaurantDTO;
import com.swithin.fooddeliveryservice.payload.RestaurantPayload;
import com.swithin.fooddeliveryservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/restaurants")
    public RestaurantDTO addRestaurant(@RequestBody RestaurantPayload payload) {
        RestaurantDTO restaurantDTO = restaurantService.addRestaurant(payload);
        return restaurantDTO;
    }

    @GetMapping("/restaurants")
    public List<RestaurantDTO> getRestaurants() {
        List<RestaurantDTO> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public RestaurantDTO getRestaurantById(@PathVariable("id") Long id) {
        RestaurantDTO restaurantDTO = restaurantService.getRestaurantById(id);
        return restaurantDTO;
    }

    @PatchMapping("restaurants/{id}")
    public RestaurantDTO updateRestaurant(@PathVariable("id") Long id, @RequestBody RestaurantPayload payload) {
        RestaurantDTO restaurantDTO = restaurantService.updateRestaurant(id, payload);
        return restaurantDTO;
    }


}
