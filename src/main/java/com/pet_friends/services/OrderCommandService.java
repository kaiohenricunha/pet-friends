package com.pet_friends.services;

import com.pet_friends.commands.CreateOrderCommand;
import com.pet_friends.entities.OrderEntity;
import com.pet_friends.events.OrderCreatedEvent;
import com.pet_friends.repositories.OrderRepository;
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
    private final OrderRepository orderRepository;

    /**
     * Constructs the OrderCommandService with the provided services and repository.
     *
     * @param orderQueryService The service for querying order events.
     * @param orderRepository   The repository for persisting orders.
     */
    @Autowired
    public OrderCommandService(OrderQueryService orderQueryService, OrderRepository orderRepository) {
        this.orderQueryService = orderQueryService;
        this.orderRepository = orderRepository;
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

        // Save the order entity to the database
        OrderEntity orderEntity = new OrderEntity(orderCreatedEvent.getOrderId(), orderCreatedEvent.getProduct(), orderCreatedEvent.getQuantity());
        orderRepository.save(orderEntity);

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
