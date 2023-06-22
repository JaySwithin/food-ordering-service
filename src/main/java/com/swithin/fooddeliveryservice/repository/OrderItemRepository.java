package com.swithin.fooddeliveryservice.repository;

import com.swithin.fooddeliveryservice.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
