package com.swithin.fooddeliveryservice.service;

import com.swithin.fooddeliveryservice.dto.MenuItemDTO;
import com.swithin.fooddeliveryservice.payload.MenuItemPayload;

import java.util.List;

public interface MenuItemService {
    MenuItemDTO addMenuItem(MenuItemPayload payload, String token);

    List<MenuItemDTO> getMenuItems();

    MenuItemDTO updateItem(Long id, MenuItemPayload payload, String token);
}
