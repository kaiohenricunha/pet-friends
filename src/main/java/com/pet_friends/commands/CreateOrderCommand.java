package com.pet_friends.commands;

/**
 * Command for creating a new order in the Pet Friends application.
 */
public class CreateOrderCommand extends BaseCommand {
    private final String orderId;
    private final String product;
    private final int quantity;

    public CreateOrderCommand(String orderId, String product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
