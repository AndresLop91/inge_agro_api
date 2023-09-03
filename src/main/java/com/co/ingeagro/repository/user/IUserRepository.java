package com.co.ingeagro.repository.user;

import com.co.ingeagro.data.UserData;

import java.util.List;

public interface IUserRepository {

    /**
     *
     * @param data param with all information to save
     * @return the same information and the assigned id
     */
    UserData save(UserData data);

    /**
     *
     * @param data param with all the information to update
     * @return the updated information
     */
    UserData update(UserData data);

    /**
     *
     * @param id with the unique id to find an user
     * @return the user with all the information
     */
    UserData findById(Long id);

    /**
     *
     * @param username param to search a user
     * @return the user with all the information
     */
    UserData findByUsername(String username);

    /**
     * get all the users from DB
     * @return a List with the users
     */
    List<UserData> findAll();

}
