package com.co.ingeagro.service.sellproduct.impl;

import com.co.ingeagro.repository.product.IProductRepository;
import com.co.ingeagro.repository.sellproduct.ISellProductRepository;
import com.co.ingeagro.service.sellproduct.ISellProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class SellProductService implements ISellProductService {

    private ISellProductRepository repository;

    @Autowired
    public SellProductService(ISellProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void removeProductOnCart(long productId) {
        repository.removeProductOnCart(productId);
    }
}
