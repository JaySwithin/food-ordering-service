package com.swithin.fooddeliveryservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantPayload {
    private String restaurantName;
    private String restaurantEmail;
    private String phoneNumber;
    private String restaurantAddress;
}
