package com.co.ingeagro.controller;

import com.co.ingeagro.model.Buyer;
import com.co.ingeagro.model.Gender;
import com.co.ingeagro.service.buyer.IBuyerService;
import lombok.Data;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping( path = ControllerConstants.Buyer.ROOT_REQUEST )
@CrossOrigin( origins = ControllerConstants.REQUEST_ORIGIN )
public class BuyerController {

    private IBuyerService buyerService;

    @Autowired
    public BuyerController(IBuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @RequestMapping(value= ControllerConstants.Buyer.GET_A_BUYER ,method = RequestMethod.GET)
    @ResponseBody
    public Buyer getABuyer(){
        return buyerService.getAGuestBuyer();
    }

}
