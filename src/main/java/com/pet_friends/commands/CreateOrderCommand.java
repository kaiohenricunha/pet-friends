package com.pet_friends.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Command for creating a new order in the Pet Friends application.
 */
@Getter
@NoArgsConstructor
public class CreateOrderCommand extends BaseCommand {
    private String orderId;
    private String product;
    private int quantity;

    /**
     * Constructs a new CreateOrderCommand with the specified order details.
     *
     * @param orderId  The ID of the order.
     * @param product  The product associated with the order.
     * @param quantity The quantity of the product ordered.
     */
    public CreateOrderCommand(String orderId, String product, int quantity) {
        super(); // Call the constructor of BaseCommand to set commandId and timestamp
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }
}
