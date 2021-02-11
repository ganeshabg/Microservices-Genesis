package com.tesco.demo.product.service;

import com.tesco.demo.product.entity.Product;
import com.tesco.demo.product.repository.ProductRepository;
import com.tesco.demo.response.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {


    @Autowired
    private ProductRepository repository;


    public List<ProductDetails> getProducts() {
        List<Product> productList = repository.findAll();
        return repository.findAll()
                .stream()
                .map(product -> ProductDetails.builder()
                        .productName(product.getName())
                        .price(product.getPrice())
                        .build())
                .collect(Collectors.toList());

    }

    public ProductDetails getProductById(int productId) {
        Product product = repository.getOne(productId);
        return ProductDetails.builder()
                .productName(product.getName())
                .price(product.getPrice())
                .build();
    }

}
