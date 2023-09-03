package com.co.ingeagro.repository.sellproduct;

public interface ISellProductRepository {

    /**
     * delete in cascade
     * @param productId the product id
     */
    void removeProductOnCart(Long productId);

}
