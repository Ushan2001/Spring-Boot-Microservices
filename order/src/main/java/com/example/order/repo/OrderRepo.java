package com.example.order.repo;

import com.example.order.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderRepo extends JpaRepository<Orders, Integer> {
}
