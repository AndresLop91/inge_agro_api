package com.co.ingeagro.converter.person;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.gender.GenderConverter;
import com.co.ingeagro.converter.identificationtype.IdentificationTypeConverter;
import com.co.ingeagro.data.GenderData;
import com.co.ingeagro.data.IdentificationTypeData;
import com.co.ingeagro.data.PersonData;
import com.co.ingeagro.model.Gender;
import com.co.ingeagro.model.IdentificationType;
import com.co.ingeagro.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class PersonConverter implements Converter<PersonData, Person> {

    private final Converter<IdentificationTypeData, IdentificationType> identificationTypeConverter;
    private final Converter<GenderData, Gender> genderConverter;

    @Autowired
    public PersonConverter(IdentificationTypeConverter identificationTypeConverter,
                           GenderConverter genderConverter) {
        this.identificationTypeConverter = identificationTypeConverter;
        this.genderConverter = genderConverter;
    }

    @Override
    public PersonData convert2Data(Person model) {
        if(Objects.isNull(model)){
            return null;
        }
        return PersonData.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .bornDate(model.getBornDate())
                .identificationNumber(model.getIdentificationNumber())
                .identificationType(identificationTypeConverter.convert2Data(model.getIdentificationType()))
                .gender(genderConverter.convert2Data(model.getGender()))
                .timeCreation(model.getTimeCreation())
                .build();
    }

    @Override
    public Person convert2Model(PersonData data) {
        if(Objects.isNull(data)){
            return null;
        }
        return Person.builder()
                .id(data.getId())
                .firstName(data.getFirstName())
                .lastName(data.getLastName())
                .bornDate(data.getBornDate())
                .identificationNumber(data.getIdentificationNumber())
                .identificationType(identificationTypeConverter.convert2Model(data.getIdentificationType()))
                .gender(genderConverter.convert2Model(data.getGender()))
                .timeCreation(data.getTimeCreation())
                .build();
    }
}
