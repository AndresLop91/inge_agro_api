package com.co.ingeagro.service.user.impl;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.user.UserConverter;
import com.co.ingeagro.data.UserData;
import com.co.ingeagro.exception.IngeagroException;
import com.co.ingeagro.model.Buyer;
import com.co.ingeagro.model.Seller;
import com.co.ingeagro.model.User;
import com.co.ingeagro.repository.user.IUserRepository;
import com.co.ingeagro.service.buyer.IBuyerService;
import com.co.ingeagro.service.seller.ISellerService;
import com.co.ingeagro.service.user.IUserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class UserService implements IUserService {

    private final IUserRepository repository;
    private final IBuyerService buyerService;
    private final ISellerService sellerService;
    private final Converter<UserData, User> converter;

    @Autowired
    public UserService(IUserRepository repository,
                       UserConverter converter,
                       IBuyerService buyerService,
                       ISellerService sellerService) {
        this.repository = repository;
        this.converter = converter;
        this.buyerService = buyerService;
        this.sellerService = sellerService;
    }

    @Override
    public User login(User model) throws Exception {
        if(Objects.isNull(model)){
            throw new IngeagroException("No se pudo hacer login");
        }
        if(null == model.getUsername() || Strings.isBlank(model.getUsername())){
            throw new IngeagroException("El usuario no puede estar nulo o vacio");
        }
        if(null == model.getPassword() || Strings.isBlank(model.getPassword())){
            throw new IngeagroException("La constrasena no puede estar nulo o vacio");
        }
        if(existByUsername(model.getUsername())){
            User byUsername = findByUsername(model.getUsername());
            String password = model.getPassword();
            checkStringParam(password, "password");
            if(Objects.nonNull(byUsername) && !password.equals(byUsername.getPassword())){
                throw new IngeagroException("El usuario o la contrasena no coinciden");
            }

            if(Objects.nonNull(byUsername) && password.equals(byUsername.getPassword())){
                return byUsername;
            }
            throw new IngeagroException("No se pudo hacer login");
        }
        throw new IngeagroException(String.format("%s %s %s", "El usuario", model.getUsername(), "no existe"));
    }

    @Override
    public User save(User model) {
        if(Objects.isNull(model)){
            // TODO - add a personal exception
            throw new NullPointerException();
        }
        UserData byUsername = repository.findByUsername(model.getUsername());
        if(Objects.nonNull(byUsername)){
            // TODO - add a personal exception
            throw new NullPointerException("Its duplicated");
        }
        LocalDateTime now = LocalDateTime.now();
        model.setTimeCreation(now);
        if(Objects.nonNull(model.getPerson())){
            model.getPerson().setTimeCreation(now);
        }
        User registeredUser = converter.convert2Model(repository.save(converter.convert2Data(model)));
        buyerService.save(Buyer.builder().isGuest(Boolean.FALSE).user(registeredUser).build());
        sellerService.save(Seller.builder().timeCreation(now).user(registeredUser).build());
        return registeredUser;
    }

    @Override
    public User update(User model) {
        if(Objects.isNull(model)){
            throw new NullPointerException("model is null");
        }
        model.setTimeModification(LocalDateTime.now());
        return converter.convert2Model(repository.update(converter.convert2Data(model)));
    }

    @Override
    public User findById(Long id) {
        if(Objects.isNull(id)){
            throw new NullPointerException("Id is null");
        }
        if(id <= 0 ){
            // TODO - add a personal exception
            throw new NullPointerException("Id must be > 0");
        }
        return converter.convert2Model(repository.findById(id));
    }

    @Override
    public User findByUsername(String username) {
        checkStringParam(username, "username");
        return converter.convert2Model(repository.findByUsername(username));
    }

    @Override
    public List<User> findAll() {
        return converter.convertAll2Model(repository.findAll());
    }

    private boolean existByUsername(String username){
        checkStringParam(username, "username");
        return repository.findByUsername(username) != null;
    }

    private void checkStringParam(String param, String fieldName) {
        if(Objects.isNull(param)){
            throw new NullPointerException(String.format("param %s cannot be null", fieldName));
        }
        if(Strings.isBlank(param)){
            throw new NullPointerException(String.format("param %s cannot be empty", fieldName));
        }
    }
}
