package com.tesco.demo.controller;

import com.tesco.demo.response.OrderResponse;
import com.tesco.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/byCustomerId")
    public ResponseEntity<List<OrderResponse>> byCustomerId(@RequestParam("customerId") int customerId) {
        return ResponseEntity.ok(orderService.getOrderByCustomerId(customerId));
    }


}
