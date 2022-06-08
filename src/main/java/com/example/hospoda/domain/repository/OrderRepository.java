package com.example.hospoda.domain.repository;

import com.example.hospoda.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    Optional<Order> findBycustomer_id(Integer customerId);
}
