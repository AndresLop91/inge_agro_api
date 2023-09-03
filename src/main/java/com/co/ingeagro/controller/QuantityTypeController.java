package com.co.ingeagro.controller;

import com.co.ingeagro.model.QuantityType;
import com.co.ingeagro.service.quantitytype.IQuantityTypeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping( path = ControllerConstants.QuantityType.ROOT_REQUEST )
@CrossOrigin( origins = ControllerConstants.REQUEST_ORIGIN )
public class QuantityTypeController {

    private IQuantityTypeService service;

    @Autowired
    public QuantityTypeController(IQuantityTypeService service) {
        this.service = service;
    }

    @RequestMapping(value= ControllerConstants.FIND_ALL ,method = RequestMethod.GET)
    @ResponseBody
    public List<QuantityType> getAll(){
        return service.getAll();
    }
}
