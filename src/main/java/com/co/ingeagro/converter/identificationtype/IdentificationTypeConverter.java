package com.co.ingeagro.converter.identificationtype;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.data.IdentificationTypeData;
import com.co.ingeagro.model.IdentificationType;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class IdentificationTypeConverter implements Converter<IdentificationTypeData, IdentificationType> {
    @Override
    public IdentificationTypeData convert2Data(IdentificationType model) {
        if(Objects.isNull(model)){
            return null;
        }
        return IdentificationTypeData.builder()
                .id(model.getId())
                .identificationType(model.getIdentificationType())
                .build();
    }

    @Override
    public IdentificationType convert2Model(IdentificationTypeData data) {
        if(Objects.isNull(data)){
            return null;
        }
        return IdentificationType.builder()
                .id(data.getId())
                .identificationType(data.getIdentificationType())
                .build();
    }
}
