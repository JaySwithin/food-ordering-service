package com.swithin.fooddeliveryservice.service;

import com.swithin.fooddeliveryservice.config.EntityMapper;
import com.swithin.fooddeliveryservice.dto.UserDTO;
import com.swithin.fooddeliveryservice.entity.User;
import com.swithin.fooddeliveryservice.errors.UserAlreadyExistException;
import com.swithin.fooddeliveryservice.errors.UserNotFoundException;
import com.swithin.fooddeliveryservice.payload.UserPayload;
import com.swithin.fooddeliveryservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final EntityMapper mapper;

    @Override
    public UserDTO createUser(UserPayload payload) {
        Optional<User> existingUser = userRepository.findUserByEmail(payload.getEmail());
        if(existingUser.isPresent()) {
            throw new UserAlreadyExistException("User already exists");
        }

        User user = User.builder()
                .firstName(payload.getFirstName())
                .lastName(payload.getLastName())
                .email(payload.getEmail())
                .password(payload.getPassword())
                .phoneNumber(payload.getPhoneNumber())
                .deliveryAddress(payload.getDeliveryAddress())
                .build();

        var res = userRepository.save(user);
        return mapper.userToDTO(res);
    }

    @Override
    public UserDTO updateUser(Long id, UserPayload payload) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User does not exist"));
        mapper.updateFields(user, payload);
        var res = userRepository.save(user);
        return mapper.userToDTO(res);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User does not exist"));
        var res = mapper.userToDTO(user);
        return res;
    }
}
