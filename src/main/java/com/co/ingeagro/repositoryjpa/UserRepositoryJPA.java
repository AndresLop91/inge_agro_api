package com.co.ingeagro.repositoryjpa;

import com.co.ingeagro.data.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * JPA Gender Abstraction
 */
public interface UserRepositoryJPA extends JpaRepository<UserData, Long> {

    /**
     *
     * @param username criteria to search a user
     * @return a user with all the information
     */
    Optional<UserData> findByUsername(String username);

}
