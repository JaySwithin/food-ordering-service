package com.swithin.fooddeliveryservice.dto;

import com.swithin.fooddeliveryservice.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String restaurantName;
    private String firstName;
    private String lastName;
    private LocalDateTime orderTime;
    private String deliveryAddress;
    private String status;
    private double totalAmount;
    private List<OrderItem> orderItems;
}
