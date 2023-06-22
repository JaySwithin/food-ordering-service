package com.swithin.fooddeliveryservice.errors;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException (String message) {
        super(message);
    }
 }
