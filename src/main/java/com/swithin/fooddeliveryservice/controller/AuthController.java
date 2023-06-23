package com.swithin.fooddeliveryservice.controller;

import com.swithin.fooddeliveryservice.payload.LoginPayload;
import com.swithin.fooddeliveryservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/login")
    public String login(@RequestBody LoginPayload payload) {
        return authService.login(payload);
    }

    @PostMapping("/auth/logout")
    public void logout(@RequestParam String token) {
        authService.logout(token);
    }
}
