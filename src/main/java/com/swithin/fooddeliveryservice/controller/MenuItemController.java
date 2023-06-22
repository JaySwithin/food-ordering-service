package com.swithin.fooddeliveryservice.controller;

import com.swithin.fooddeliveryservice.dto.MenuItemDTO;
import com.swithin.fooddeliveryservice.payload.MenuItemPayload;
import com.swithin.fooddeliveryservice.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class MenuItemController {
    private final MenuItemService menuItemService;

    @PostMapping("/items")
    public MenuItemDTO addItem(@RequestBody MenuItemPayload payload) {
        MenuItemDTO menuItem = menuItemService.addMenuItem(payload);
        return menuItem;
    }

    @GetMapping("/items")
    public List<MenuItemDTO> getItems() {
        List<MenuItemDTO> items = menuItemService.getMenuItems();
        return items;
    }

    @PatchMapping("items/{id}")
    public MenuItemDTO updateItem(@PathVariable("id") Long id, @RequestBody MenuItemPayload payload) {
        MenuItemDTO menuItemDTO = menuItemService.updateItem(id, payload);
        return menuItemDTO;
    }

}
