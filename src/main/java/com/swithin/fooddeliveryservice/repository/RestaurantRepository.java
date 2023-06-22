package com.swithin.fooddeliveryservice.repository;

import com.swithin.fooddeliveryservice.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
