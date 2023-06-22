package com.swithin.fooddeliveryservice.config;

import com.swithin.fooddeliveryservice.dto.MenuItemDTO;
import com.swithin.fooddeliveryservice.dto.RestaurantDTO;
import com.swithin.fooddeliveryservice.entity.MenuItem;
import com.swithin.fooddeliveryservice.entity.Restaurant;
import com.swithin.fooddeliveryservice.payload.MenuItemPayload;
import com.swithin.fooddeliveryservice.payload.RestaurantPayload;
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

    void updateFields(@MappingTarget Restaurant restaurant, RestaurantPayload payload);

    void updateFields(@MappingTarget MenuItem menuItem, MenuItemPayload payload);
}
