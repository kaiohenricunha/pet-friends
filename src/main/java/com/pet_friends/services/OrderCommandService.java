package com.pet_friends.services;

import com.pet_friends.commands.CreateOrderCommand;
import com.pet_friends.events.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for handling commands related to orders in the Pet Friends application.
 */
@Service
public class OrderCommandService {

    private final List<OrderCreatedEvent> orders = new ArrayList<>();

    private final OrderQueryService orderQueryService;

    /**
     * Constructs the OrderCommandService with the provided OrderQueryService.
     *
     * @param orderQueryService The service for querying order events.
     */
    @Autowired
    public OrderCommandService(OrderQueryService orderQueryService) {
        this.orderQueryService = orderQueryService;
    }

    /**
     * Executes the given CreateOrderCommand.
     *
     * @param command The command to create a new order.
     * @return The OrderCreatedEvent representing the created order.
     */
    public OrderCreatedEvent handleCreateOrderCommand(CreateOrderCommand command) {
        // Create an OrderCreatedEvent based on the command
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(
                command.getOrderId(),
                command.getProduct(),
                command.getQuantity()
        );

        // Simulate persisting the event to an event store
        orders.add(orderCreatedEvent);

        // Add the event to the query service
        orderQueryService.addOrderEvent(orderCreatedEvent);

        // Return the created event as a response
        return orderCreatedEvent;
    }

    /**
     * Retrieves all created orders (simulating reading from the event store).
     *
     * @return A list of all created orders.
     */
    public List<OrderCreatedEvent> getAllOrders() {
        return new ArrayList<>(orders);
    }
}
