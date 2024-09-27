package com.pet_friends.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing an Order in the Pet Friends application.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    private String orderId;
    private String product;
    private int quantity;

    public Order(String orderId, String product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }
}
