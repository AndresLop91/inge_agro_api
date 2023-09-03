package com.co.ingeagro.service.profile.impl;

import com.co.ingeagro.model.Buyer;
import com.co.ingeagro.model.Profile;
import com.co.ingeagro.model.Seller;
import com.co.ingeagro.model.User;
import com.co.ingeagro.service.buyer.IBuyerService;
import com.co.ingeagro.service.profile.IProfileService;
import com.co.ingeagro.service.seller.ISellerService;
import com.co.ingeagro.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProfileService implements IProfileService {

    private final IBuyerService buyerService;
    private final ISellerService sellerService;
    private final IUserService userService;

    @Autowired
    public ProfileService(IBuyerService buyerService,
                          ISellerService sellerService,
                          IUserService userService) {
        this.buyerService = buyerService;
        this.sellerService = sellerService;
        this.userService = userService;
    }

    @Override
    public Profile getProfileById(Long userId) {
        User userByID = userService.findById(userId);

        Buyer buyer = buyerService.getByUserId(userId);
        Seller seller =  sellerService.getByUserId(userId);
        User user = null;

        if(Objects.nonNull(buyer) && Objects.nonNull(seller) && Objects.nonNull(buyer.getUser())
                && Objects.nonNull(seller.getUser())
                && buyer.getUser().getId().equals(seller.getUser().getId())){
            user = seller.getUser();
        }

        return Profile.builder()
                .buyer(buyer)
                .seller(seller)
                .user(user)
                .build();
    }
}
