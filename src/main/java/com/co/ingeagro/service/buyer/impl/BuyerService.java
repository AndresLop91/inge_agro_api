package com.co.ingeagro.service.buyer.impl;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.buyer.BuyerConverter;
import com.co.ingeagro.data.BuyerData;
import com.co.ingeagro.model.Buyer;
import com.co.ingeagro.repository.buyer.IBuyerRepository;
import com.co.ingeagro.service.buyer.IBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class BuyerService implements IBuyerService {

    private final IBuyerRepository buyerRepository;
    private final Converter<BuyerData, Buyer> converter;

    @Autowired
    public BuyerService(IBuyerRepository buyerRepository, BuyerConverter converter) {
        this.buyerRepository = buyerRepository;
        this.converter = converter;
    }

    @Override
    public Buyer getByUserId(Long userId) {
        return converter.convert2Model(buyerRepository.getByUserId(userId));
    }

    @Override
    public Buyer save(Buyer buyer) {
        if(Objects.isNull(buyer)){
            throw new NullPointerException("buyer is null");
        }
        return converter.convert2Model(buyerRepository.save(converter.convert2Data(buyer)));
    }

    @Override
    public Buyer getAGuestBuyer() {
        Buyer b = Buyer.builder()
                .isGuest(Boolean.TRUE)
                .timeCreation(LocalDateTime.now())
                .build();

        BuyerData buyerData = converter.convert2Data(b);
        BuyerData savedGuestUser = buyerRepository.getAGuestBuyer(buyerData);
        return converter.convert2Model(savedGuestUser);
    }
}
