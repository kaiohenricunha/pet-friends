package com.pet_friends.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing an Order in the Pet Friends application.
 */
@Entity(name = "order_entity")
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity {
    @Id
    private String orderId;
    private String product;
    private int quantity;

    public OrderEntity(String orderId, String product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }
}
