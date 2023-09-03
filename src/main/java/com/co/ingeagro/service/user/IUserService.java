package com.co.ingeagro.service.user;

import com.co.ingeagro.model.User;

import java.util.List;

public interface IUserService {

    /**
     *
     * @param model with username and password to login
     * @return the logged person
     */
    User login(User model) throws Exception;

    /**
     *
     * @param model param with all information to save
     * @return the same information and the assigned id
     */
    User save(User model);

    /**
     *
     * @param model param with all the information to update
     * @return the updated information
     */
    User update(User model);

    /**
     *
     * @param id with the unique id to find an user
     * @return the user with all the information
     */
    User findById(Long id);

    /**
     *
     * @param username param to search a user
     * @return the user with all the information
     */
    User findByUsername(String username);

    /**
     * get all the users from DB
     * @return a List with the users
     */
    List<User> findAll();
}
