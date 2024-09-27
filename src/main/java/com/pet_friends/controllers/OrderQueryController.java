package com.pet_friends.controllers;

import com.pet_friends.entities.OrderEntity;
import com.pet_friends.services.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST Controller for handling order queries in the Pet Friends application.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderQueryController {

    private final OrderQueryService orderQueryService;

    @Autowired
    public OrderQueryController(OrderQueryService orderQueryService) {
        this.orderQueryService = orderQueryService;
    }

    /**
     * Endpoint to get all orders.
     *
     * @return ResponseEntity containing a list of all orders.
     */
    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrders() {
        List<OrderEntity> orders = orderQueryService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    /**
     * Endpoint to get an order by its ID.
     *
     * @param orderId The ID of the order to retrieve.
     * @return ResponseEntity containing the found OrderEntity or a 404 response if not found.
     */
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderEntity> getOrderById(@PathVariable String orderId) {
        Optional<OrderEntity> orderEntity = orderQueryService.getOrderEntityById(orderId);
        return orderEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
