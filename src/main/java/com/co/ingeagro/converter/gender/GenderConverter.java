package com.co.ingeagro.converter.gender;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.data.GenderData;
import com.co.ingeagro.model.Gender;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service(value = "genderConverter")
public class GenderConverter implements Converter<GenderData, Gender> {
    @Override
    public GenderData convert2Data(Gender gender) {
        if(Objects.isNull(gender)){
            return null;
        }
        return GenderData.builder()
                .id(gender.getId())
                .genderName(gender.getGenderName())
                .build();
    }

    @Override
    public Gender convert2Model(GenderData genderData) {
        if (Objects.isNull(genderData)){
            return null;
        }
        return Gender.builder()
                .id(genderData.getId())
                .genderName(genderData.getGenderName())
                .build();
    }
}
