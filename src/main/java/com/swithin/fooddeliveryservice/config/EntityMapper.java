package com.swithin.fooddeliveryservice.config;

import com.swithin.fooddeliveryservice.dto.*;
import com.swithin.fooddeliveryservice.entity.*;
import com.swithin.fooddeliveryservice.payload.MenuItemPayload;
import com.swithin.fooddeliveryservice.payload.RestaurantPayload;
import com.swithin.fooddeliveryservice.payload.UserPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface EntityMapper {

    @Mapping(target = "id", source = "restaurantId")
    RestaurantDTO restaurantToDto(Restaurant restaurant);

    @Mapping(target = "id", source = "itemId")
    MenuItemDTO menuItemToDTO(MenuItem menuItem);

    @Mapping(target = "id", source = "userId")
    UserDTO userToDTO(User user);

    @Mapping(target = "id", source = "orderId")
    @Mapping(target = "restaurantName", source = "order.restaurant.restaurantName")
    @Mapping(target = "firstName", source = "order.user.firstName")
    @Mapping(target = "lastName", source = "order.user.lastName")
    @Mapping(target = "orderItems", source = "order.orderItems")
    OrderDTO orderToDTO(Order order);

    void updateFields(@MappingTarget Restaurant restaurant, RestaurantPayload payload);

    void updateFields(@MappingTarget MenuItem menuItem, MenuItemPayload payload);

    void updateFields(@MappingTarget User user, UserPayload payload);
}
