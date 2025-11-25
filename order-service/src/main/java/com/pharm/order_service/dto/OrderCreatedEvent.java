package com.pharm.order_service.dto;

import lombok.Data;
@Data
public class OrderCreatedEvent {
    
    private Long orderId;
    private Long userId;
    private String drugCode;
    private int quantity;

    @Override
    public String toString() {
        return "OrderCreatedEvent{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", drugCode='" + drugCode + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
