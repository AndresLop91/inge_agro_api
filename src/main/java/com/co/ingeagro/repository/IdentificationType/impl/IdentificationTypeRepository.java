package com.co.ingeagro.repository.IdentificationType.impl;

import com.co.ingeagro.data.IdentificationTypeData;
import com.co.ingeagro.repository.IdentificationType.IIdentificationTypeRepository;
import com.co.ingeagro.repositoryjpa.IdentificationTypeRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IdentificationTypeRepository implements IIdentificationTypeRepository {

    private final IdentificationTypeRepositoryJPA repositoryJPA;

    @Autowired
    public IdentificationTypeRepository(IdentificationTypeRepositoryJPA repositoryJPA) {
        this.repositoryJPA = repositoryJPA;
    }

    @Override
    public List<IdentificationTypeData> findAll() {
        return repositoryJPA.findAll();
    }
}
