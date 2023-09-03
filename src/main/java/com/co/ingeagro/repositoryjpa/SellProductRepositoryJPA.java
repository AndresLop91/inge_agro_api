package com.co.ingeagro.repositoryjpa;

import com.co.ingeagro.data.SellProductData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellProductRepositoryJPA extends JpaRepository<SellProductData, Long> {


    void deleteByProductId(Long productId);

}
