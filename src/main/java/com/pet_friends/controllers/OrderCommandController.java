package com.pet_friends.controllers;

import com.pet_friends.commands.CreateOrderCommand;
import com.pet_friends.events.OrderCreatedEvent;
import com.pet_friends.services.OrderCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * REST Controller for handling order commands in the Pet Friends application.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderCommandController {

    private final OrderCommandService orderCommandService;

    @Autowired
    public OrderCommandController(OrderCommandService orderCommandService) {
        this.orderCommandService = orderCommandService;
    }

    /**
     * Endpoint to create a new order.
     *
     * @param command The CreateOrderCommand containing order details.
     * @return ResponseEntity containing the OrderCreatedEvent details.
     */
    @PostMapping
    public ResponseEntity<OrderCreatedEvent> createOrder(@RequestBody CreateOrderCommand commandRequest) {
        // Generate a unique order ID if not provided
        String orderId = (commandRequest.getOrderId() == null || commandRequest.getOrderId().isEmpty()) 
                ? UUID.randomUUID().toString() 
                : commandRequest.getOrderId();

        // Create a new command instance with the proper order ID
        CreateOrderCommand command = new CreateOrderCommand(orderId, commandRequest.getProduct(), commandRequest.getQuantity());

        // Handle the command using the OrderCommandService
        OrderCreatedEvent createdEvent = orderCommandService.handleCreateOrderCommand(command);

        return ResponseEntity.ok(createdEvent);
    }
}
