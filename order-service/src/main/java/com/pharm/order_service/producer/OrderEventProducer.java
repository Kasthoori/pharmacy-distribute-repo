package com.pharm.order_service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.pharm.order_service.dto.OrderCreatedEvent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderEventProducer {
    
    // private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public void publishOrderCreated(OrderCreatedEvent event) {
        String key = event.getOrderId().toString();
        kafkaTemplate.send("orders.created", key, event);
    }
}
