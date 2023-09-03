package com.co.ingeagro.repository.producttype.impl;

import com.co.ingeagro.data.ProductTypeData;
import com.co.ingeagro.repository.producttype.IProductTypeRepository;
import com.co.ingeagro.repositoryjpa.ProductTypeRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductTypeRepository implements IProductTypeRepository {

    private final ProductTypeRepositoryJPA repository;

    @Autowired
    public ProductTypeRepository(ProductTypeRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductTypeData> findAll() {
        return repository.findAll();
    }
}
