package com.swithin.fooddeliveryservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPayload {
    private Long restaurantId;
    private Long userId;
    private String deliveryAddress;
    private String status;
    private List<OrderItemPayload> items;
}
