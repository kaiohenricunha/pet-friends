package com.pet_friends.services;

import com.pet_friends.entities.OrderEntity;
import com.pet_friends.events.OrderCreatedEvent;
import com.pet_friends.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service for handling queries related to orders in the Pet Friends application.
 */
@Service
public class OrderQueryService {

    private final List<OrderCreatedEvent> orderEvents;
    private final OrderRepository orderRepository;

    /**
     * Constructs the OrderQueryService with the provided OrderRepository.
     *
     * @param orderRepository The repository for accessing persisted orders.
     */
    @Autowired
    public OrderQueryService(OrderRepository orderRepository) {
        this.orderEvents = new ArrayList<>();
        this.orderRepository = orderRepository;
    }

    /**
     * Retrieves all order creation events.
     *
     * @return A list of all OrderCreatedEvents.
     */
    public List<OrderCreatedEvent> getAllOrderEvents() {
        return new ArrayList<>(orderEvents);
    }

    /**
     * Adds a new order creation event to the list.
     *
     * @param event The OrderCreatedEvent to add.
     */
    public void addOrderEvent(OrderCreatedEvent event) {
        this.orderEvents.add(event);
    }

    /**
     * Retrieves an order entity by its ID.
     *
     * @param orderId The ID of the order to retrieve.
     * @return An Optional containing the found OrderEntity or empty if not found.
     */
    public Optional<OrderEntity> getOrderEntityById(String orderId) {
        return orderRepository.findById(orderId);
    }
}
