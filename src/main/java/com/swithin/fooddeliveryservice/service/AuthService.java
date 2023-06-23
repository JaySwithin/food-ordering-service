package com.swithin.fooddeliveryservice.service;

import com.swithin.fooddeliveryservice.payload.LoginPayload;

public interface AuthService {
    String login(LoginPayload payload);
    void logout(String token);
}
