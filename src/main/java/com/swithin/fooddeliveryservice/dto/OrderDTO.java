package com.swithin.fooddeliveryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private RestaurantDTO restaurant;
    private UserDTO user;
    private LocalDateTime orderTime;
    private String deliveryAddress;
}
