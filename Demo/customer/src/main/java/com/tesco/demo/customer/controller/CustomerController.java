package com.tesco.demo.customer.controller;

import com.tesco.demo.customer.client.ProductClient;
import com.tesco.demo.customer.service.CustomerService;
import com.tesco.demo.customer.service.OrderService;
import com.tesco.demo.request.CreateOrderRequest;
import com.tesco.demo.request.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private ProductClient productClient;

    private OrderService orderService;

    private CustomerService customerService;

    @Autowired
    public CustomerController(ProductClient productClient, OrderService orderService, CustomerService customerService) {
        this.productClient = productClient;
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerRequest customerRequest) {
        customerService.createCustomer(customerRequest);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/order")
    public void createOrder(@RequestBody CreateOrderRequest orderRequest) {
        orderService.initOrder(orderRequest);
    }

}
