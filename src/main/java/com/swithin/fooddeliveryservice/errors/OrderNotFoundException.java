package com.swithin.fooddeliveryservice.errors;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException (String message) {
        super(message);
    }
}
