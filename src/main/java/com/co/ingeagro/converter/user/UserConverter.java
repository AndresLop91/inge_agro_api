package com.co.ingeagro.converter.user;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.person.PersonConverter;
import com.co.ingeagro.data.PersonData;
import com.co.ingeagro.data.UserData;
import com.co.ingeagro.model.Person;
import com.co.ingeagro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserConverter implements Converter<UserData, User> {
    private final Converter<PersonData, Person> personConverter;

    @Autowired
    public UserConverter(PersonConverter personConverter) {
        this.personConverter = personConverter;
    }

    @Override
    public UserData convert2Data(User model) {
        if(Objects.isNull(model)){
            return null;
        }
        return UserData.builder()
                .id(model.getId())
                .username(model.getUsername())
                .password(model.getPassword())
                .timeCreation(model.getTimeCreation())
                .timeModification(model.getTimeModification())
                .lng(model.getLng())
                .lat(model.getLat())
                .person(personConverter.convert2Data(model.getPerson()))
                .build();
    }

    @Override
    public User convert2Model(UserData data) {
        if (Objects.isNull(data)) {
            return null;
        }
        return User.builder()
                .id(data.getId())
                .username(data.getUsername())
                .password(data.getPassword())
                .timeCreation(data.getTimeCreation())
                .timeModification(data.getTimeModification())
                .lng(data.getLng())
                .lat(data.getLat())
                .person(personConverter.convert2Model(data.getPerson()))
                .build();
    }
}
