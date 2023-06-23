package com.swithin.fooddeliveryservice.controller;

import com.swithin.fooddeliveryservice.dto.UserDTO;
import com.swithin.fooddeliveryservice.payload.UserPayload;
import com.swithin.fooddeliveryservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserPayload payload) {
        UserDTO userDTO = userService.createUser(payload);
        return userDTO;
    }

    @GetMapping("/users/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id,
                               @RequestParam String token) {
        UserDTO userDTO = userService.getUserById(id, token);
        return userDTO;
    }

    @PatchMapping("/users/{id}")
    public UserDTO updateUser(@PathVariable("id") Long id,
                              @RequestBody UserPayload payload,
                              @RequestParam String token) {
        UserDTO userDTO = userService.updateUser(id, payload, token);
        return userDTO;
    }
}
