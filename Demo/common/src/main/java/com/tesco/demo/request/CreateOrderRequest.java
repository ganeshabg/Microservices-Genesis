package com.tesco.demo.request;

import lombok.Data;

import java.util.Set;

@Data
public class CreateOrderRequest {

    private int customerId;
    private Set<Integer> productIds;

}
