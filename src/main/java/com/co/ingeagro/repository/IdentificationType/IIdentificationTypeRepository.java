package com.co.ingeagro.repository.IdentificationType;

import com.co.ingeagro.data.IdentificationTypeData;

import java.util.List;

public interface IIdentificationTypeRepository {

    /**
     * get the list of identifications from DB
     * @return the list of identifications
     */
    List<IdentificationTypeData> findAll();

}
