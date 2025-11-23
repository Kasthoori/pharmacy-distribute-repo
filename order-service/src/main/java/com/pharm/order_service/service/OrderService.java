package com.pharm.order_service.service;

import org.springframework.stereotype.Service;

import com.pharm.order_service.dto.OrderCreatedEvent;
import com.pharm.order_service.enums.OrderStatus;
import com.pharm.order_service.modal.Order;
import com.pharm.order_service.producer.OrderEventProducer;
import com.pharm.order_service.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private  final OrderRepository orderRepository;
    private final OrderEventProducer orderEventProducer;

    public Order createOrder(Long userId, String drugCode, int quantity) {
        Order order = Order.builder()
                .userId(userId)
                .drugCode(drugCode)
                .quantity(quantity)
                .status(OrderStatus.PENDING)
                .build();

        Order saved = orderRepository.save(order);

        OrderCreatedEvent event = new OrderCreatedEvent();
        event.setOrderId(saved.getId());
        event.setUserId(userId);
        event.setDrugCode(drugCode);
        event.setQuantity(quantity);

        orderEventProducer.publishOrderCreated(event);

        return saved;
    }
    
}
