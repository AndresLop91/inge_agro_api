package com.co.ingeagro.service.quantitytype;

import com.co.ingeagro.model.QuantityType;

import java.util.List;

public interface IQuantityTypeService {

    /**
     *
     * @return a list with all the quantity types
     */
    List<QuantityType> getAll();

}
