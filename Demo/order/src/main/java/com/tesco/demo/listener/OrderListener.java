package com.tesco.demo.listener;

import com.tesco.demo.beans.OrderEvent;
import com.tesco.demo.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {


    private OrderService orderService;

    @Autowired
    public OrderListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = "${order.queue}")
    public void receiveOrder(OrderEvent orderEvent) {
        orderService.createOrder(orderEvent);
    }
}
