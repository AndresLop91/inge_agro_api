package com.co.ingeagro.service.producttype.impl;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.producttype.ProductTypeConverter;
import com.co.ingeagro.data.ProductTypeData;
import com.co.ingeagro.model.ProductType;
import com.co.ingeagro.repository.producttype.IProductTypeRepository;
import com.co.ingeagro.service.producttype.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {

    private IProductTypeRepository repository;
    private Converter<ProductTypeData, ProductType> converter;

    @Autowired
    public ProductTypeService(IProductTypeRepository repository, ProductTypeConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<ProductType> getAll() {
        List<ProductTypeData> all = repository.findAll();
        return converter.convertAll2Model(all);
    }
}
