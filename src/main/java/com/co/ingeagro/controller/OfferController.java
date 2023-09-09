package com.co.ingeagro.controller;

import com.co.ingeagro.data.ProductData;
import com.co.ingeagro.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/OfferProduct")


public class OfferController {

    @Autowired
    private IProductRepository productRepository;

    @GetMapping("/first5")
    public List<ProductData> getFirst5Products() {
        return productRepository.getAll(PageRequest.of(0, 5)).getContent();
    }
}




