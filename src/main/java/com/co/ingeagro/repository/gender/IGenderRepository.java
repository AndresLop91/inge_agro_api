package com.co.ingeagro.repository.gender;

import com.co.ingeagro.data.GenderData;

import java.util.List;

public interface IGenderRepository {

    /**
     * Return list of gender from DB
     * @return a List of Genders
     */
    List<GenderData> findAll();
}
