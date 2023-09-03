package com.co.ingeagro.repository.seller;

import com.co.ingeagro.data.ProductData;
import com.co.ingeagro.data.SellerData;

import java.util.List;

public interface ISellerRepository {

    /**
     *
     * @param userId to search a seller
     * @return a seller with all the information or null
     */
    SellerData findByUserId(Long userId);

    /**
     *
     * @param seller to save
     * @return saved seller
     */
    SellerData save(SellerData seller);

    /**
     *
     * @param id to find a seller
     * @return a seller given an id
     */
    SellerData getById(Long id);

    /**
     *
     * @param sellerId the id of the seller
     * @return a list of products
     */
    List<ProductData> getAllBySellerId(Long sellerId);

}
