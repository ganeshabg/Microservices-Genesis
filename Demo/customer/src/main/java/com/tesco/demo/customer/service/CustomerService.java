package com.tesco.demo.customer.service;

import com.tesco.demo.customer.entity.Customer;
import com.tesco.demo.customer.repository.CustomerRepository;
import com.tesco.demo.request.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public void createCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                            .name(customerRequest.getName())
                            .phoneNumber(customerRequest.getPhoneNumber())
                            .age(customerRequest.getAge())
                            .build();
        customerRepository.save(customer);
    }


}
