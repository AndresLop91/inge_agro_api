package com.co.ingeagro.converter.buyer;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.guestuser.GuestUserConverter;
import com.co.ingeagro.converter.user.UserConverter;
import com.co.ingeagro.data.BuyerData;
import com.co.ingeagro.data.GuestUserData;
import com.co.ingeagro.data.UserData;
import com.co.ingeagro.model.Buyer;
import com.co.ingeagro.model.GuestUser;
import com.co.ingeagro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BuyerConverter implements Converter<BuyerData, Buyer> {

    private final Converter<UserData, User> userConverter;
    private final Converter<GuestUserData, GuestUser> guestUserConverter;

    @Autowired
    public BuyerConverter(UserConverter userConverter, GuestUserConverter guestUserConverter) {
        this.userConverter = userConverter;
        this.guestUserConverter = guestUserConverter;
    }

    @Override
    public BuyerData convert2Data(Buyer model) {
        if(Objects.isNull(model)){
            return null;
        }
        return BuyerData.builder()
                .id(model.getId())
                .user(userConverter.convert2Data(model.getUser()))
                .isGuest(model.getIsGuest())
                .creationTime(model.getTimeCreation())
                .guestUser(guestUserConverter.convert2Data(model.getGuestUser()))
                .build();
    }

    @Override
    public Buyer convert2Model(BuyerData data) {
        if(Objects.isNull(data)){
            return null;
        }
        return Buyer.builder()
                .id(data.getId())
                .user(userConverter.convert2Model(data.getUser()))
                .isGuest(data.getIsGuest())
                .timeCreation(data.getCreationTime())
                .guestUser(guestUserConverter.convert2Model(data.getGuestUser()))
                .build();
    }
}
