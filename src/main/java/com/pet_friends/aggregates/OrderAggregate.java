package com.pet_friends.aggregates;

import com.pet_friends.commands.CreateOrderCommand;
import com.pet_friends.events.OrderCreatedEvent;
import com.pet_friends.services.OrderCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Aggregate class for managing orders in the Pet Friends application.
 */
@Component
public class OrderAggregate {

    private final OrderCommandService orderCommandService;
    
    // Internal state of the aggregate
    private String orderId;
    private String product;
    private int quantity;

    /**
     * Constructs the OrderAggregate with the provided OrderCommandService.
     *
     * @param orderCommandService The service for handling order commands.
     */
    @Autowired
    public OrderAggregate(OrderCommandService orderCommandService) {
        this.orderCommandService = orderCommandService;
    }

    /**
     * Handles the CreateOrderCommand and updates the state of the aggregate.
     *
     * @param command The command to create a new order.
     * @return The resulting OrderCreatedEvent.
     */
    public OrderCreatedEvent handle(CreateOrderCommand command) {
        // Use the OrderCommandService to handle the command
        OrderCreatedEvent event = orderCommandService.handleCreateOrderCommand(command);
        
        // Apply the event to update the aggregate state
        apply(event);
        
        return event;
    }

    /**
     * Applies the OrderCreatedEvent to update the state of the aggregate.
     *
     * @param event The event representing the creation of an order.
     */
    public void apply(OrderCreatedEvent event) {
        this.orderId = event.getOrderId();
        this.product = event.getProduct();
        this.quantity = event.getQuantity();
    }

    // Getters for aggregate state (for demonstration purposes)
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
