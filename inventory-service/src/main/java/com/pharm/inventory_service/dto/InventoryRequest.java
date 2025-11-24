package com.pharm.inventory_service.dto;

import lombok.Data;

@Data
public class InventoryRequest {
    private String drugCode;
    private Integer quantity;
}
