package com.pharm.inventory_service.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.pharm.inventory_service.event.OrderCreatedEvent;
import com.pharm.inventory_service.model.InventoryItem;
import com.pharm.inventory_service.repository.InventoryRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class InventoryOrderListener {

    private final InventoryRepository inventoryRepository;


    @KafkaListener(topics = "orders.created", groupId = "inventory-service-group")
    @Transactional
    public void handleOrderCreated(OrderCreatedEvent event) {

        log.info("Received order-created event {}", event);

        InventoryItem item = inventoryRepository.findByDrugCode(event.getDrugCode())
                .orElseThrow(() -> new RuntimeException("No inventory for" + event.getDrugCode()));

        if (item.getQuantity() < event.getQuantity()) {
            log.warn("Not enough stock for {}", event.getDrugCode());
            return;
        }

        item.setQuantity(item.getQuantity() - event.getQuantity());
        inventoryRepository.save(item);

        log.info("Inventory updated for {} new quantity = {}", item.getDrugCode(), item.getQuantity());

    }
    
}
