package com.tesco.demo.service;

import com.tesco.demo.beans.OrderEvent;
import com.tesco.demo.client.ProductClient;
import com.tesco.demo.entity.Order;
import com.tesco.demo.entity.OrderDetails;
import com.tesco.demo.repository.OrderRepository;
import com.tesco.demo.response.OrderResponse;
import com.tesco.demo.response.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ProductClient productClient;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    public void createOrder(OrderEvent orderEvent) {
        Order order = Order.builder()
                .customerId(orderEvent.getCustomerId())
                .status("created")
                .build();
        order.setOrderDetailsSet(orderEvent.getProductIds()
                .stream()
                .map(pId -> OrderDetails
                        .builder()
                        .productId(pId)
                        .order(order)
                        .build())
                .collect(Collectors.toSet()));
        orderRepository.save(order);
    }


    public List<OrderResponse> getOrderByCustomerId(int customerId) {
        List<Order> orderList = orderRepository.findOrderByCustomerId(customerId);
        return orderList.stream()
                .map(order -> OrderResponse.builder()
                                .orderId(order.getId())
                                .products( order.getOrderDetailsSet()
                                        .stream()
                                        .map(orderDetails -> {
                                            var productDetails = productClient.byId(orderDetails.getProductId());
                                            return ProductDetails.builder()
                                                    .productName(productDetails.getProductName())
                                                    .price(productDetails.getPrice())
                                                    .build();
                                        }).collect(Collectors.toList()))
                                .build()
                        ).collect(Collectors.toList());
    }

}
