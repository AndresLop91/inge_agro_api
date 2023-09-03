package com.co.ingeagro.repository.sellproduct.impl;

import com.co.ingeagro.repository.sellproduct.ISellProductRepository;
import com.co.ingeagro.repositoryjpa.SellProductRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;

public class SellProductRepository implements ISellProductRepository {

    private SellProductRepositoryJPA jpa;

    @Autowired
    public SellProductRepository(SellProductRepositoryJPA jpa) {
        this.jpa = jpa;
    }

    @Override
    public void removeProductOnCart(Long productId) {

    }
}
