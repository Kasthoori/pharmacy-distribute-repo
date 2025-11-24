package com.pharm.order_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharm.order_service.dto.CreateOrderRequest;
import com.pharm.order_service.modal.Order;
import com.pharm.order_service.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order create(@RequestBody CreateOrderRequest req) {
        return orderService.createOrder(req.getUserId(), req.getDrugCode(), req.getQuantity());
    }
    
}
