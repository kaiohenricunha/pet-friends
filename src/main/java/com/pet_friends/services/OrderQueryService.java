package com.pet_friends.services;

import com.pet_friends.events.OrderCreatedEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for handling queries related to orders in the Pet Friends application.
 */
@Service
public class OrderQueryService {

    private final List<OrderCreatedEvent> orderEvents;

    /**
     * Constructs the OrderQueryService with an initial list of order events.
     */
    public OrderQueryService() {
        // Initialize with an empty list of events
        this.orderEvents = new ArrayList<>();
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
}
