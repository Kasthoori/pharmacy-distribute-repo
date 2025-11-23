package com.pharm.order_service.dto;

import lombok.Data;

@Data
public class CreateOrderRequest {

    private Long userId;
    private String drugCode;
    private int quantity;
}
    