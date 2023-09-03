package com.co.ingeagro.repository.quantitytype.impl;

import com.co.ingeagro.data.QuantityTypeData;
import com.co.ingeagro.repository.quantitytype.IQuantityTypeRepository;
import com.co.ingeagro.repositoryjpa.QuantityTypeRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuantityTypeRepository implements IQuantityTypeRepository {

    private QuantityTypeRepositoryJPA jpa;

    @Autowired
    public QuantityTypeRepository(QuantityTypeRepositoryJPA jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<QuantityTypeData> getAll() {
        return jpa.findAll();
    }
}
