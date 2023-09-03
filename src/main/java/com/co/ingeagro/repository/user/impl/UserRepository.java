package com.co.ingeagro.repository.user.impl;

import com.co.ingeagro.data.UserData;
import com.co.ingeagro.repository.user.IUserRepository;
import com.co.ingeagro.repositoryjpa.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    private final UserRepositoryJPA repositoryJPA;

    @Autowired
    public UserRepository(UserRepositoryJPA repositoryJPA) {
        this.repositoryJPA = repositoryJPA;
    }

    @Override
    public UserData save(UserData data) {
        return repositoryJPA.save(data);
    }

    @Override
    public UserData update(UserData data) {
        return repositoryJPA.save(data);
    }

    @Override
    public UserData findById(Long id) {
        return repositoryJPA.findById(id).orElse(null);
    }

    @Override
    public UserData findByUsername(String username) {
        return repositoryJPA.findByUsername(username).orElse(null);
    }

    @Override
    public List<UserData> findAll() {
        return repositoryJPA.findAll();
    }
}
