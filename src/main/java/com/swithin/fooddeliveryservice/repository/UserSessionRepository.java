package com.swithin.fooddeliveryservice.repository;

import com.swithin.fooddeliveryservice.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
    Optional<UserSession> findByUUID(String token);
}
