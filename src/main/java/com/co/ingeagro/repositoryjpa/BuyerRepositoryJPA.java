package com.co.ingeagro.repositoryjpa;

import com.co.ingeagro.data.BuyerData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Buyer Abstraction
 */
public interface BuyerRepositoryJPA extends JpaRepository<BuyerData, Long> {

    /**
     *
     * @param userId to search a buyer
     * @return the buyer with all the information or null
     */
    BuyerData getByUserId(Long userId);

}
