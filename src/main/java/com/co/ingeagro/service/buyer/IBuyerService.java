package com.co.ingeagro.service.buyer;

import com.co.ingeagro.model.Buyer;

public interface IBuyerService {

    /**
     *
     * @param userId to serach the buyer
     * @return a buyer with all the information
     */
    Buyer getByUserId(Long userId);

    /**
     *
     * @param buyer to save
     * @return a saved buyer
     */
    Buyer save(Buyer buyer);

    Buyer getAGuestBuyer();

}
