package com.swithin.fooddeliveryservice.service;

import com.swithin.fooddeliveryservice.dto.OrderDTO;
import com.swithin.fooddeliveryservice.payload.OrderPayload;

public interface OrderService {
    OrderDTO createOrder(OrderPayload payload, String token);
    OrderDTO fulfillOrder(Long id, String token);
}
