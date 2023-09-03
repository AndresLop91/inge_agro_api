package com.co.ingeagro.repository.gender.impl;

import com.co.ingeagro.data.GenderData;
import com.co.ingeagro.repository.gender.IGenderRepository;
import com.co.ingeagro.repositoryjpa.GenderRepositoryJPA;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Data
@Repository
public class GenderRepository implements IGenderRepository {

    private final GenderRepositoryJPA genderRepositoryJPA;

    @Autowired
    public GenderRepository(GenderRepositoryJPA genderRepositoryJPA) {
        this.genderRepositoryJPA = genderRepositoryJPA;
    }

    public List<GenderData> findAll(){
        return genderRepositoryJPA.findAll();
    }

}
