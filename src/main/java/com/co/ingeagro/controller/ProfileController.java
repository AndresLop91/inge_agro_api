package com.co.ingeagro.controller;

import com.co.ingeagro.model.Profile;
import com.co.ingeagro.service.profile.IProfileService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping( path = ControllerConstants.Profile.ROOT_REQUEST )
@CrossOrigin( origins = ControllerConstants.REQUEST_ORIGIN )
public class ProfileController {

    private final IProfileService profileService;

    @Autowired
    public ProfileController(IProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(value= ControllerConstants.Profile.LOGIN ,method = RequestMethod.GET)
    public ResponseEntity<Object> getProfileByUserId(@Param("userId") final Long userId) {
        Profile profileById = profileService.getProfileById(userId);
        return new ResponseEntity<>(profileById, HttpStatus.OK);
    }

}
