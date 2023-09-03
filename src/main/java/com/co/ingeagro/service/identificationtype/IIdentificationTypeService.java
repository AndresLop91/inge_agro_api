package com.co.ingeagro.service.identificationtype;

import com.co.ingeagro.model.IdentificationType;

import java.util.List;

public interface IIdentificationTypeService {

    /**
     * return a list of identifications
     * @return a List of identifications
     */
    List<IdentificationType> findAll();

}
