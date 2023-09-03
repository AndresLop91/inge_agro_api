package com.co.ingeagro.repository.quantitytype;

import com.co.ingeagro.data.QuantityTypeData;

import java.util.List;

public interface IQuantityTypeRepository {

    /**
     *
     * @return all the document types in the db
     */
    List<QuantityTypeData> getAll();

}
