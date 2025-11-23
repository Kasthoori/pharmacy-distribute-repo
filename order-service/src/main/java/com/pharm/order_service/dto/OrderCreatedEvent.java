package com.pharm.order_service.dto;

import lombok.Data;

@Data
public class OrderCreatedEvent {
    
    private Long orderId;
    private Long userId;
    private String drugCode;
    private int quantity;
}
