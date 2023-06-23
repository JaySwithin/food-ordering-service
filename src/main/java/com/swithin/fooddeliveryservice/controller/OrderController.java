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
    public OrderDTO createOrder(@RequestBody OrderPayload payload,
                                @RequestParam String token) {
        OrderDTO orderDTO = orderService.createOrder(payload, token);
        return orderDTO;
    }


    @PutMapping("/orders/{id}/fulfill")
    public OrderDTO fulfillOrder(@PathVariable("id") Long id,
                                 @RequestParam String token) {
        OrderDTO orderDTO = orderService.fulfillOrder(id, token);
        return orderDTO;
    }

}
