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
        return orderCommandService.handleCreateOrderCommand(command);
    }
}
