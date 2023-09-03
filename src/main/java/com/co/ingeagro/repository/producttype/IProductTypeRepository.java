package com.co.ingeagro.repository.producttype;

import com.co.ingeagro.data.ProductTypeData;

import java.util.List;

public interface IProductTypeRepository {

    /**
     * Return a list of products types from DB
     * @return a list of genders
     */
    List<ProductTypeData> findAll();


}
