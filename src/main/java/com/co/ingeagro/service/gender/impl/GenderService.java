package com.co.ingeagro.service.gender.impl;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.gender.GenderConverter;
import com.co.ingeagro.data.GenderData;
import com.co.ingeagro.model.Gender;
import com.co.ingeagro.repository.gender.IGenderRepository;
import com.co.ingeagro.service.gender.IGenderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Data
@Service
public class GenderService implements IGenderService {

    private IGenderRepository repository;
    private Converter<GenderData, Gender> converter;

    @Autowired
    public GenderService(IGenderRepository repository, GenderConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<Gender> getAll() {
        List<GenderData> all = getRepository().findAll();
        return converter.convertAll2Model(all);
    }
}
