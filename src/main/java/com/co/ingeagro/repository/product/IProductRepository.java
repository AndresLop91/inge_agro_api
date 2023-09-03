package com.co.ingeagro.repository.product;

import com.co.ingeagro.data.ProductData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductRepository {

    /**
     *
     * @param products to save
     * @return save products
     */
    List<ProductData> saveAll(List<ProductData> products);

    /**
     *
     * @return all products from db
     */
    List<ProductData> getAll();

    /**
     *
     * @param pageable page
     * @return paged products
     */
    Page<ProductData> getAll(Pageable pageable);

    /**
     *
     * @return a list of products by seller id
     */
    List<ProductData> getBySellerId(Long sellerId);

    /**
     * Gets a product given its id
     * @param productId the product id
     * @return a product from DB
     */
    ProductData getById(Long productId);

    /**
     * Remove product by its id
     * @param productId the product id
     */
    void removeByProductId(Long productId);


}
