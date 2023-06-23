package com.swithin.fooddeliveryservice.service;

import com.swithin.fooddeliveryservice.config.EntityMapper;
import com.swithin.fooddeliveryservice.dto.OrderDTO;
import com.swithin.fooddeliveryservice.entity.*;
import com.swithin.fooddeliveryservice.errors.AuthException;
import com.swithin.fooddeliveryservice.errors.OrderNotFoundException;
import com.swithin.fooddeliveryservice.errors.RestaurantNotFoundException;
import com.swithin.fooddeliveryservice.errors.UserNotFoundException;
import com.swithin.fooddeliveryservice.payload.OrderItemPayload;
import com.swithin.fooddeliveryservice.payload.OrderPayload;
import com.swithin.fooddeliveryservice.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final RestaurantRepository restaurantRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;
    private final UserSessionRepository userSessionRepository;
    private final EntityMapper mapper;
    @Override
    public OrderDTO createOrder(OrderPayload payload, String token) {
        userSessionRepository.findByUUID(token).orElseThrow(() ->
                new AuthException("Unauthorized. User not logged in."));
        Restaurant restaurant = restaurantRepository.findById(payload.getRestaurantId())
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with ID: " + payload.getRestaurantId()));
        User user = userRepository.findById(payload.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + payload.getUserId()));
        Order order = new Order();
        order.setRestaurant(restaurant);
        order.setUser(user);
        order.setOrderTime(LocalDateTime.now());
        order.setDeliveryAddress(payload.getDeliveryAddress());
        order.setStatus("Pending");

        double totalAmount = 0.0;
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemPayload itemPayload : payload.getItems()) {
            MenuItem menuItem = restaurant.getMenu().stream()
                    .filter(menu -> menu.getItemId().equals(itemPayload.getItemId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Menu item not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setItemId(menuItem.getItemId());
            orderItem.setQuantity(itemPayload.getQuantity());

            double itemTotal = menuItem.getItemPrice() * itemPayload.getQuantity();
            totalAmount += itemTotal;

            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        order.setTotalAmount(totalAmount);

        var savedOrder = orderRepository.save(order);

        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(savedOrder);
            orderItemRepository.save(orderItem);
        }

        var res = mapper.orderToDTO(savedOrder);
        res.setRestaurantName(savedOrder.getRestaurant().getRestaurantName());
        res.setFirstName(savedOrder.getUser().getFirstName());
        res.setLastName(savedOrder.getUser().getLastName());
        res.setOrderItems(orderItems);

        return res;
    }

    @Override
    public OrderDTO fulfillOrder(Long id, String token) {
        userSessionRepository.findByUUID(token).orElseThrow(() ->
                new AuthException("Unauthorized. User not logged in."));
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(String.format("Order not found with ID: {id=%d}", id)));
        order.setStatus("Fulfilled");
        var res = orderRepository.save(order);
        return mapper.orderToDTO(res);
    }
}
