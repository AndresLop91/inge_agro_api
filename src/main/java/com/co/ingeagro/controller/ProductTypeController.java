package com.co.ingeagro.controller;

import com.co.ingeagro.model.ProductType;
import com.co.ingeagro.service.producttype.IProductTypeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping( path = ControllerConstants.ProductType.ROOT_REQUEST )
@CrossOrigin( origins = ControllerConstants.REQUEST_ORIGIN )
public class ProductTypeController {

    private IProductTypeService service;

    @Autowired
    public ProductTypeController(IProductTypeService service) {
        this.service = service;
    }

    @RequestMapping(value= ControllerConstants.FIND_ALL ,method = RequestMethod.GET)
    @ResponseBody
    public List<ProductType> getAll(){
        return service.getAll();
    }
}
