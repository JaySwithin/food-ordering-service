package com.swithin.fooddeliveryservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPayload {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String deliveryAddress;
}
