package com.swithin.fooddeliveryservice.controller;

import com.swithin.fooddeliveryservice.dto.OrderDTO;
import com.swithin.fooddeliveryservice.payload.OrderPayload;
import com.swithin.fooddeliveryservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/orders")
    public OrderDTO createOrder(@RequestBody OrderPayload payload) {
        OrderDTO orderDTO = orderService.createOrder(payload);
        return orderDTO;
    }


    @PutMapping("/orders/{id}/fulfill")
    public OrderDTO fulfillOrder(@PathVariable("id") Long id) {
        OrderDTO orderDTO = orderService.fulfillOrder(id);
        return orderDTO;
    }

}
