package com.co.ingeagro.service.seller;

import com.co.ingeagro.exception.IngeagroException;
import com.co.ingeagro.model.Product;
import com.co.ingeagro.model.Seller;

import java.util.List;

public interface ISellerService {

    /**
     *
     * @param userId to search a seller
     * @return the seller with all the information or null
     */
    Seller getByUserId(Long userId);

    /**
     *
     * @param seller to save
     * @return saved seller
     */
    Seller save(Seller seller);

    /**
     *
     * @param id to find a seller
     * @return a seller given an id
     */
    Seller getById(Long id);

    /**
     *
     * @param sellerId id of the seller
     * @param productList new list of products for the seller
     */
    void updateProducts(Long sellerId, List<Product> productList) throws IngeagroException;

    /**
     *
     * @param sellerId the id of the seller
     * @return a List of the products given the seller id
     */
    List<Product> getAllBySellerId(Long sellerId);

}
