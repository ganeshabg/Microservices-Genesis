package com.tesco.demo.product.controller;

import com.tesco.demo.product.service.ProductService;
import com.tesco.demo.response.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDetails>> productList() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/byId")
    public ResponseEntity<ProductDetails> byId(@RequestParam("productId") int productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }


}
