package com.swithin.fooddeliveryservice.service;

import com.swithin.fooddeliveryservice.entity.User;
import com.swithin.fooddeliveryservice.entity.UserSession;
import com.swithin.fooddeliveryservice.errors.AuthException;
import com.swithin.fooddeliveryservice.errors.UserNotFoundException;
import com.swithin.fooddeliveryservice.payload.LoginPayload;
import com.swithin.fooddeliveryservice.repository.UserRepository;
import com.swithin.fooddeliveryservice.repository.UserSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserSessionRepository userSessionRepository;
    @Override
    public String login(LoginPayload payload) {
        User user = userRepository.findUserByEmail(payload.getEmail()).orElseThrow(() ->
                new UserNotFoundException(String.format("User not found with email %s", payload.getEmail())));

        if(!Objects.equals(user.getPassword(), payload.getPassword())) {
            throw new AuthException("Invalid credentials");
        }
        var id = UUID.randomUUID().toString();
        UserSession userSession = UserSession.builder()
                .userId(user.getUserId())
                .UUID(id)
                .timestamp(LocalDateTime.now())
                .build();

        var savedUserSession = userSessionRepository.save(userSession);
        return savedUserSession.getUUID();
    }

    @Override
    public void logout(String token) {
        UserSession userSession = userSessionRepository.findByUUID(token).orElseThrow(() ->
                new AuthException("Invalid token"));
        userSessionRepository.delete(userSession);
    }
}
