package com.pharm.inventory_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharm.inventory_service.model.InventoryItem;
import com.pharm.inventory_service.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryRepository repo;

    @GetMapping
    public List<InventoryItem> all() {
        return repo.findAll();
    }

    
    
}
