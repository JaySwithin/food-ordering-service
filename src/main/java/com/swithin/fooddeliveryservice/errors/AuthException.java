package com.swithin.fooddeliveryservice.errors;

public class AuthException extends RuntimeException {
    public AuthException (String message) {
        super(message);
    }
}
