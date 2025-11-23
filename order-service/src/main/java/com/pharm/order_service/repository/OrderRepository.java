package com.pharm.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharm.order_service.modal.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
