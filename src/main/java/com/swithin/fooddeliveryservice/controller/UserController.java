package com.swithin.fooddeliveryservice.controller;

import com.swithin.fooddeliveryservice.dto.ErrorResponseDTO;
import com.swithin.fooddeliveryservice.dto.UserDTO;
import com.swithin.fooddeliveryservice.payload.UserPayload;
import com.swithin.fooddeliveryservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
@Tag(name = "User")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "CREATED"),
        @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
})
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    @Operation(summary = "Create a new user.")
    public UserDTO createUser(@RequestBody UserPayload payload) {
        UserDTO userDTO = userService.createUser(payload);
        return userDTO;
    }

    @GetMapping("/users/{id}")
    @Operation(summary = "Get a user's details.")
    public UserDTO getUserById(@PathVariable("id") Long id,
                               @RequestParam String token) {
        UserDTO userDTO = userService.getUserById(id, token);
        return userDTO;
    }

    @PatchMapping("/users/{id}")
    @Operation(summary = "Update a user's details.")
    public UserDTO updateUser(@PathVariable("id") Long id,
                              @RequestBody UserPayload payload,
                              @RequestParam String token) {
        UserDTO userDTO = userService.updateUser(id, payload, token);
        return userDTO;
    }
}
