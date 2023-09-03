package com.co.ingeagro.repository.buyer.impl;

import com.co.ingeagro.data.BuyerData;
import com.co.ingeagro.model.Buyer;
import com.co.ingeagro.repository.buyer.IBuyerRepository;
import com.co.ingeagro.repositoryjpa.BuyerRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BuyerRepository implements IBuyerRepository {

    private final BuyerRepositoryJPA repositoryJPA;

    @Autowired
    public BuyerRepository(BuyerRepositoryJPA repositoryJPA) {
        this.repositoryJPA = repositoryJPA;
    }

    @Override
    public BuyerData getByUserId(Long userId) {
        return repositoryJPA.getByUserId(userId);
    }

    @Override
    public BuyerData save(BuyerData buyer) {
        return repositoryJPA.save(buyer);
    }

    @Override
    public BuyerData getAGuestBuyer(BuyerData buyer) {
        return repositoryJPA.save(buyer);
    }
}
