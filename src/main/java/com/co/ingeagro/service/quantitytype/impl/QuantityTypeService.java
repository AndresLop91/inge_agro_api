package com.co.ingeagro.service.quantitytype.impl;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.quantitytype.QuantityTypeConverter;
import com.co.ingeagro.data.QuantityTypeData;
import com.co.ingeagro.model.QuantityType;
import com.co.ingeagro.repository.quantitytype.IQuantityTypeRepository;
import com.co.ingeagro.service.quantitytype.IQuantityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuantityTypeService implements IQuantityTypeService {

    private IQuantityTypeRepository repository;
    private Converter<QuantityTypeData, QuantityType> converter;


    @Autowired
    public QuantityTypeService(IQuantityTypeRepository repository, QuantityTypeConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<QuantityType> getAll() {
        return converter.convertAll2Model(repository.getAll());
    }
}
