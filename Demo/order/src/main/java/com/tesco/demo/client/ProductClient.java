package com.tesco.demo.client;

import com.tesco.demo.response.ProductDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "${product.service.name}", url = "${product.service.url}")
public interface ProductClient {

    @GetMapping("/byId")
    ProductDetails byId(@RequestParam("productId") int productId);

}
