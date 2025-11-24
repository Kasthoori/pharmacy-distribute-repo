package com.pharm.inventory_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharm.inventory_service.dto.InventoryRequest;
import com.pharm.inventory_service.model.InventoryItem;
import com.pharm.inventory_service.service.InventoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @GetMapping
    public List<InventoryItem> all() {
        return service.all();
    }

    @PostMapping
    public InventoryItem create(@RequestBody InventoryRequest request) {
        return service.create(request);
    }


    
}
