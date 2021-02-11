package com.tesco.demo.customer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(name = "${product.service.name}", url = "${product.service.url}")
public interface ProductClient {

    @GetMapping("/getproducts")
    List<String> fecthProducts();

}
