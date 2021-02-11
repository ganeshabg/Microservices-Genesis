package com.tesco.demo.repository;

import com.tesco.demo.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order , Integer> {

    List<Order> findOrderByCustomerId(int customerId);
}
