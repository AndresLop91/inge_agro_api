package com.co.ingeagro.controller;

import com.co.ingeagro.model.Gender;
import com.co.ingeagro.service.gender.IGenderService;
import lombok.Data;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping( path = ControllerConstants.Gender.ROOT_REQUEST )
@CrossOrigin( origins = ControllerConstants.REQUEST_ORIGIN )
public class GenderController {

    private IGenderService service;

    @Autowired
    public GenderController(IGenderService service) {
        this.service = service;
    }

    @RequestMapping(value= ControllerConstants.CREATE ,method = RequestMethod.POST)
    public Gender create(@RequestBody final Gender gender) {
        throw new NotYetImplementedException();
    }

    @RequestMapping(value= ControllerConstants.UPDATE ,method = RequestMethod.POST)
    public void update(@RequestBody final Gender gender){
        throw new NotYetImplementedException();
    }

    @RequestMapping(value= ControllerConstants.FIND_BY_ID ,method = RequestMethod.GET)
    @ResponseBody
    public Gender findById(@RequestParam(value = "id") final Long id){
        throw new NotYetImplementedException();
    }

    @RequestMapping(value= ControllerConstants.FIND_ALL ,method = RequestMethod.GET)
    @ResponseBody
    public List<Gender> getAll(){
        return service.getAll();
    }
}
