package com.swithin.fooddeliveryservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemPayload {
    private Long itemId;
    private int quantity;
}
