package com.swithin.fooddeliveryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemDTO {
    private Long id;
    private String itemName;
    private Double itemPrice;
    private String itemDescription;
}
