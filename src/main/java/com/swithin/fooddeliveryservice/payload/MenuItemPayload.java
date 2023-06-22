package com.swithin.fooddeliveryservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemPayload {
    private String itemName;
    private Double itemPrice;
    private String itemDescription;
    private Long restaurantId;

}
