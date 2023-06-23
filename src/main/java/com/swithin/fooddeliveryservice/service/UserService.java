package com.swithin.fooddeliveryservice.service;

import com.swithin.fooddeliveryservice.dto.UserDTO;
import com.swithin.fooddeliveryservice.payload.UserPayload;

public interface UserService {
    UserDTO createUser(UserPayload payload);
    UserDTO updateUser(Long id, UserPayload payload, String token);
    UserDTO getUserById(Long id, String token);
}
