package com.swithin.fooddeliveryservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long itemId;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private Order order;
}
