package com.co.ingeagro.repository.seller.impl;

import com.co.ingeagro.data.ProductData;
import com.co.ingeagro.data.SellerData;
import com.co.ingeagro.repository.seller.ISellerRepository;
import com.co.ingeagro.repositoryjpa.SellerRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Repository
public class SellerRepository implements ISellerRepository {

    private final SellerRepositoryJPA repositoryJPA;

    @Autowired
    public SellerRepository(SellerRepositoryJPA repositoryJPA) {
        this.repositoryJPA = repositoryJPA;
    }

    @Override
    public SellerData findByUserId(Long userId) {
        return repositoryJPA.findByUserId(userId);
    }

    @Override
    public SellerData save(SellerData seller) {
        return repositoryJPA.save(seller);
    }

    @Override
    public SellerData getById(Long id) {
        return this.repositoryJPA.getById(id);
    }

    @Override
    public List<ProductData> getAllBySellerId(Long sellerId) {
        return repositoryJPA.getById(sellerId).getProducts();
    }
}
