package com.co.ingeagro.service.identificationtype.impl;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.identificationtype.IdentificationTypeConverter;
import com.co.ingeagro.data.IdentificationTypeData;
import com.co.ingeagro.model.IdentificationType;
import com.co.ingeagro.repository.IdentificationType.IIdentificationTypeRepository;
import com.co.ingeagro.service.identificationtype.IIdentificationTypeService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IdentificationService implements IIdentificationTypeService {

    private final IIdentificationTypeRepository repository;
    private final Converter<IdentificationTypeData, IdentificationType> converter;

    public IdentificationService(IIdentificationTypeRepository repository, IdentificationTypeConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<IdentificationType> findAll() {
        return converter.convertAll2Model(repository.findAll());
    }
}
