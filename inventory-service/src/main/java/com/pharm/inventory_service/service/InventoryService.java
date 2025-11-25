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

    public List<InventoryItem> all() {
        return inventoryRepository.findAll();
    }

    public InventoryItem create(InventoryRequest request) {

           System.out.println(">>> Incoming InventoryRequest: drugCode=" 
                + request.getDrugCode() + ", quantity=" + request.getQuantity());

            if(request.getQuantity() == null) {
                throw new IllegalArgumentException("Quantity cannot be null");
            }

            InventoryItem item = new InventoryItem();
            item.setDrugCode(request.getDrugCode());
            item.setQuantity(request.getQuantity());
            return inventoryRepository.save(item);
    }
    
}
