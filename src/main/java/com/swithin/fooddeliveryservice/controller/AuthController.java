package com.swithin.fooddeliveryservice.controller;

import com.swithin.fooddeliveryservice.dto.ErrorResponseDTO;
import com.swithin.fooddeliveryservice.payload.LoginPayload;
import com.swithin.fooddeliveryservice.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Authentication")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
})
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/login")
    @Operation(summary = "Login.")
    public String login(@RequestBody LoginPayload payload) {
        return authService.login(payload);
    }

    @PostMapping("/auth/logout")
    @Operation(summary = "Logout.")
    public void logout(@RequestParam String token) {
        authService.logout(token);
    }
}
