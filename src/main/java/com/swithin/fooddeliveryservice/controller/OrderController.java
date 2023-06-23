package com.swithin.fooddeliveryservice.controller;

import com.swithin.fooddeliveryservice.dto.ErrorResponseDTO;
import com.swithin.fooddeliveryservice.dto.OrderDTO;
import com.swithin.fooddeliveryservice.payload.OrderPayload;
import com.swithin.fooddeliveryservice.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
@Tag(name = "Order")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "CREATED"),
        @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
})
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/orders")
    @Operation(summary = "Place an order.")
    public OrderDTO createOrder(@RequestBody OrderPayload payload,
                                @RequestParam String token) {
        OrderDTO orderDTO = orderService.createOrder(payload, token);
        return orderDTO;
    }


    @PutMapping("/orders/{id}/fulfill")
    @Operation(summary = "Fulfill an order.", description = "Allows changes of order status after fulfillment")
    public OrderDTO fulfillOrder(@PathVariable("id") Long id,
                                 @RequestParam String token) {
        OrderDTO orderDTO = orderService.fulfillOrder(id, token);
        return orderDTO;
    }

}
