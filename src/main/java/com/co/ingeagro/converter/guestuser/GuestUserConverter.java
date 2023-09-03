package com.co.ingeagro.converter.guestuser;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.person.PersonConverter;
import com.co.ingeagro.data.GuestUserData;
import com.co.ingeagro.data.PersonData;
import com.co.ingeagro.model.GuestUser;
import com.co.ingeagro.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GuestUserConverter implements Converter<GuestUserData, GuestUser> {

    private final Converter<PersonData, Person> personConverter;

    @Autowired
    public GuestUserConverter(PersonConverter personConverter) {
        this.personConverter = personConverter;
    }

    @Override
    public GuestUserData convert2Data(GuestUser model) {
        if(Objects.isNull(model)){
            return null;
        }
        return GuestUserData.builder()
                .id(model.getId())
                .person(personConverter.convert2Data(model.getPerson()))
                .build();
    }

    @Override
    public GuestUser convert2Model(GuestUserData data) {
        if(Objects.isNull(data)){
            return null;
        }
        return GuestUser.builder()
                .id(data.getId())
                .person(personConverter.convert2Model(data.getPerson()))
                .build();
    }
}
