package com.co.ingeagro.service.product;

import com.co.ingeagro.exception.IngeagroException;
import com.co.ingeagro.model.Product;
import com.co.ingeagro.model.form.ProductForm;
import com.co.ingeagro.model.form.RemoveProductForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    /**
     *
     * @param product
     */
    void saveProduct(ProductForm product) throws IngeagroException;

    /**
     *
     * @param product to remove
     * @throws IngeagroException if an error happens
     */
    void removeProduct(RemoveProductForm product) throws IngeagroException;

    /**
     *
     * @return all products in database
     */
    List<Product> getAll();

    /**
     *
     * @return
     */
    Page<Product> getAll(Pageable page);

    /**
     *
     * @param sellerId to find the products
     * @return the products given a seller id
     */
    List<Product> getAllBySellerId(Long sellerId);

    /**
     * Get a product given its Id
     * @param productId the product id
     * @return a product
     */
    Product findById(Long productId) throws IngeagroException;

}
