package com.co.ingeagro.repository.product.impl;

import com.co.ingeagro.data.ProductData;
import com.co.ingeagro.repository.product.IProductRepository;
import com.co.ingeagro.repositoryjpa.ProductRepositoryJPA;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {

    private ProductRepositoryJPA jpa;

    @Autowired
    public ProductRepository(ProductRepositoryJPA jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<ProductData> saveAll(List<ProductData> products) {
        return jpa.saveAll(products);
    }

    @Override
    public List<ProductData> getAll() {
        return jpa.findAll();
    }

    @Override
    public Page<ProductData> getAll(Pageable pageable) {
        return jpa.findAll(pageable);
    }

    @Override
    public List<ProductData> getBySellerId(Long sellerId){
        throw new NotYetImplementedException();
    }

    @Override
    public ProductData getById(Long productId) {
        Optional<ProductData> byId = jpa.findById(productId);
        return byId.orElse(null);
    }

    @Override
    public void removeByProductId(Long productId) {
        jpa.deleteById(productId);
    }
}
