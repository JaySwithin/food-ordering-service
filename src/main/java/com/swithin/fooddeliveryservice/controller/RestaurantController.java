package com.swithin.fooddeliveryservice.controller;

import com.swithin.fooddeliveryservice.dto.ErrorResponseDTO;
import com.swithin.fooddeliveryservice.dto.RestaurantDTO;
import com.swithin.fooddeliveryservice.payload.RestaurantPayload;
import com.swithin.fooddeliveryservice.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
@Tag(name = "Restaurant")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "CREATED"),
        @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
})
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/restaurants")
    @Operation(summary = "Add a new restaurant to the database.")
    public RestaurantDTO addRestaurant(@RequestBody RestaurantPayload payload,
                                       @RequestParam String token) {
        RestaurantDTO restaurantDTO = restaurantService.addRestaurant(payload, token);
        return restaurantDTO;
    }

    @GetMapping("/restaurants")
    @Operation(summary = "Get all restaurants.", description = "Allows users to browse all restaurants")
    public List<RestaurantDTO> getRestaurants() {
        List<RestaurantDTO> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    @Operation(summary = "Get a restaurant.", description = "Allows users to view the menu of a restaurant")
    public RestaurantDTO getRestaurantById(@PathVariable("id") Long id) {
        RestaurantDTO restaurantDTO = restaurantService.getRestaurantById(id);
        return restaurantDTO;
    }

    @PatchMapping("restaurants/{id}")
    @Operation(summary = "Update a restaurant's details.")
    public RestaurantDTO updateRestaurant(@PathVariable("id") Long id,
                                          @RequestBody RestaurantPayload payload,
                                          @RequestParam String token) {
        RestaurantDTO restaurantDTO = restaurantService.updateRestaurant(id, payload, token);
        return restaurantDTO;
    }


}
