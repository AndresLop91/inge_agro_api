package com.co.ingeagro.controller;

import com.co.ingeagro.model.Profile;
import com.co.ingeagro.model.User;
import com.co.ingeagro.service.profile.IProfileService;
import com.co.ingeagro.service.user.IUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;
// http://localhost:8383/user/save

@Data
@RestController
@RequestMapping( path = ControllerConstants.User.ROOT_REQUEST )
@CrossOrigin( origins = ControllerConstants.REQUEST_ORIGIN )
public class UserController {

    private final IUserService userService;
    private final IProfileService profileService;

    @Autowired
    public UserController(IUserService userService,
                          IProfileService profileService) {
        this.userService = userService;
        this.profileService = profileService;
    }

    @RequestMapping(value= ControllerConstants.User.LOGIN ,method = RequestMethod.POST)
    public User login(@RequestBody final User user) throws Exception{
        return userService.login(user);
    }

    @RequestMapping(value= ControllerConstants.User.LOGIN_PROFILE ,method = RequestMethod.POST)
    public Profile loginProfile(@RequestBody final User user) throws Exception{
        User loggedUser = userService.login(user);
        if(Objects.nonNull(loggedUser)){
            return profileService.getProfileById(loggedUser.getId());
        }
        throw new NullPointerException("An error has occurred when trying to login");
    }

    @RequestMapping(value= ControllerConstants.SAVE ,method = RequestMethod.POST)
    public User save(@RequestBody final User user) {
        return userService.save(user);
    }

    @RequestMapping(value= ControllerConstants.UPDATE ,method = RequestMethod.PATCH)
    public User update(@RequestBody final User user) {
        return userService.update(user);
    }

    @RequestMapping(value= ControllerConstants.FIND_BY_ID ,method = RequestMethod.GET)
    public User findById(@Param("id") Long id) {
        return userService.findById(id);
    }

    @RequestMapping(value= ControllerConstants.User.FIND_BY_USERNAME ,method = RequestMethod.GET)
    public User findByUsername(@Param("username") String username) {
        return userService.findByUsername(username);
    }

    @RequestMapping(value= ControllerConstants.FIND_ALL ,method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    }

}
