package com.co.ingeagro.service.producttype;

import com.co.ingeagro.model.ProductType;

import java.util.List;

public interface IProductTypeService {

    /**
     * Return a list with all product types
     * @return list pf all product types
     */
    List<ProductType> getAll();
}
