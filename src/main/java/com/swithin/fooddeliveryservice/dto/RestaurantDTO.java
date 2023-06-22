package com.swithin.fooddeliveryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {
    private Long id;
    private String restaurantName;
    private String restaurantEmail;
    private String phoneNumber;
    private String restaurantAddress;
    private List<MenuItemDTO> menu;
}
