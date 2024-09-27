package com.pet_friends.repositories;

import com.pet_friends.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Order entities.
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {
}
