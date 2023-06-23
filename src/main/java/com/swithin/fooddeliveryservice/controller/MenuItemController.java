package com.swithin.fooddeliveryservice.controller;

import com.swithin.fooddeliveryservice.dto.ErrorResponseDTO;
import com.swithin.fooddeliveryservice.dto.MenuItemDTO;
import com.swithin.fooddeliveryservice.payload.MenuItemPayload;
import com.swithin.fooddeliveryservice.service.MenuItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
@Tag(name = "Menu Item")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "CREATED"),
        @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
})
public class MenuItemController {
    private final MenuItemService menuItemService;

    @PostMapping("/items")
    @Operation(summary = "Add a new menu item to the database.")
    public MenuItemDTO addItem(@RequestBody MenuItemPayload payload,
                               @RequestParam String token) {
        MenuItemDTO menuItem = menuItemService.addMenuItem(payload, token);
        return menuItem;
    }

    @GetMapping("/items")
    @Operation(summary = "Gte all menu items in the database.")
    public List<MenuItemDTO> getItems() {
        List<MenuItemDTO> items = menuItemService.getMenuItems();
        return items;
    }

    @PatchMapping("items/{id}")
    @Operation(summary = "Update a restaurant's menu item.")
    public MenuItemDTO updateItem(@PathVariable("id") Long id,
                                  @RequestBody MenuItemPayload payload,
                                  @RequestParam String token) {
        MenuItemDTO menuItemDTO = menuItemService.updateItem(id, payload, token);
        return menuItemDTO;
    }

}
