package com.swithin.fooddeliveryservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long restaurantId;

    @Column(nullable = false)
    private String restaurantName;

    @Column(nullable = false)
    private String restaurantEmail;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String restaurantAddress;

    @OneToMany(mappedBy = "restaurant")
    private List<Order> restaurantOrders;

    @OneToMany(mappedBy = "restaurant")
    private List<MenuItem> menu;
}
