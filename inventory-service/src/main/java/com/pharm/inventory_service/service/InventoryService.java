package com.pharm.inventory_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pharm.inventory_service.dto.InventoryRequest;
import com.pharm.inventory_service.model.InventoryItem;
import com.pharm.inventory_service.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {
    
    private final InventoryRepository inventoryRepository;
    private final InventoryRepository repo;

    public List<InventoryItem> all() {
        return repo.findAll();
    }

    public InventoryItem create(InventoryRequest request) {
            InventoryItem item = new InventoryItem();
            item.setDrugCode(request.getDrugCode());
            item.setQuantity(request.getQuantity());
            return inventoryRepository.save(item);
    }
    
}
