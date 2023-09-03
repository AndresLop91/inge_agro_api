package com.co.ingeagro.service.gender;

import com.co.ingeagro.model.Gender;

import java.util.List;

public interface IGenderService {

    /**
     * Get all gender
     * @return a list with all genders
     */
    List<Gender> getAll();

}
