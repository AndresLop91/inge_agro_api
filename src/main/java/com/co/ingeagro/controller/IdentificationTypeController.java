package com.co.ingeagro.controller;

import com.co.ingeagro.model.IdentificationType;
import com.co.ingeagro.service.identificationtype.IIdentificationTypeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping( path = ControllerConstants.IdentificationType.ROOT_REQUEST )
@CrossOrigin( origins = ControllerConstants.REQUEST_ORIGIN )
public class IdentificationTypeController {

    private final IIdentificationTypeService service;

    @Autowired
    public IdentificationTypeController(IIdentificationTypeService service) {
        this.service = service;
    }

    @RequestMapping(value= ControllerConstants.FIND_ALL ,method = RequestMethod.GET)
    @ResponseBody
    public List<IdentificationType> findAll(){
        return service.findAll();
    }
}
