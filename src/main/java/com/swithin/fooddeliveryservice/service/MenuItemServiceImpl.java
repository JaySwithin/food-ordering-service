package com.swithin.fooddeliveryservice.service;

import com.swithin.fooddeliveryservice.config.EntityMapper;
import com.swithin.fooddeliveryservice.dto.MenuItemDTO;
import com.swithin.fooddeliveryservice.entity.MenuItem;
import com.swithin.fooddeliveryservice.entity.Restaurant;
import com.swithin.fooddeliveryservice.errors.MenuItemNotFoundException;
import com.swithin.fooddeliveryservice.errors.RestaurantNotFoundException;
import com.swithin.fooddeliveryservice.payload.MenuItemPayload;
import com.swithin.fooddeliveryservice.repository.MenuItemRepository;
import com.swithin.fooddeliveryservice.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {
    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;
    private final EntityMapper mapper;

    @Override
    public MenuItemDTO addMenuItem(MenuItemPayload payload) {

        Restaurant restaurant = restaurantRepository.findById(payload.getRestaurantId()).orElseThrow(() ->
                new RestaurantNotFoundException(String.format("Goal was not found with parameters {id=%d}", payload.getRestaurantId())));

        MenuItem menuItem = MenuItem.builder()
                .itemName(payload.getItemName())
                .itemPrice(payload.getItemPrice())
                .itemDescription(payload.getItemDescription())
                .restaurant(restaurant)
                .build();

        var res = menuItemRepository.save(menuItem);
        return mapper.menuItemToDTO(res);
    }

    @Override
    public List<MenuItemDTO> getMenuItems() {
        var items = menuItemRepository.findAll();
        return items.stream()
                .map(mapper::menuItemToDTO).
                collect(Collectors.toList());
    }

    @Override
    public MenuItemDTO updateItem(Long id, MenuItemPayload payload) {
        MenuItem item = menuItemRepository.findById(id).orElseThrow(() ->
                new MenuItemNotFoundException(String.format("Goal was not found with parameters {id=%d}", id)));
        mapper.updateFields(item, payload);
        var res = menuItemRepository.save(item);
        return mapper.menuItemToDTO(res);
    }


}
