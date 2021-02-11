package com.tesco.demo.customer.service;


import com.tesco.demo.beans.OrderEvent;
import com.tesco.demo.request.CreateOrderRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderService {


    private String exchange;
    private String routingKey;
    private RabbitTemplate template;

    @Autowired
    public OrderService(@Value("${order.exchange}") String exchange,
                        @Value("${order.routingkey}") String routingKey,
                        RabbitTemplate template) {
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.template = template;
    }

    public void initOrder(CreateOrderRequest createOrderRequest) {
        OrderEvent orderEvent = OrderEvent.builder()
                .customerId(createOrderRequest.getCustomerId())
                .productIds(createOrderRequest.getProductIds())
                .build();
        template.convertAndSend(exchange, routingKey, orderEvent);
    }
}
