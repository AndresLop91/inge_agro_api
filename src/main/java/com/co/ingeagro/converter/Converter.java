package com.co.ingeagro.converter;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @param <DATA>
 * @param <MODEL>
 */
public interface Converter<DATA, MODEL>{

    /**
     *
     * @param model to convert to
     * @return DATA
     */
    DATA convert2Data(MODEL model);

    /**
     *
     * @param data to convert to
     * @return MODEL
     */
    MODEL convert2Model(DATA data);

    /**
     *
     * @param data list to convert to
     * @return list of MODEL
     */
    default List<MODEL> convertAll2Model(List<DATA> data) {
        if(CollectionUtils.isEmpty(data)){
            return Collections.EMPTY_LIST;
        }
        return data.stream().map(this::convert2Model).collect(Collectors.toList());
    }

    /**
     *
     * @param model list to convert to
     * @return list of DATA
     */
    default List<DATA> convertAll2Data(List<MODEL> model) {
        if(CollectionUtils.isEmpty(model)){
            return Collections.EMPTY_LIST;
        }
        return model.stream().map(this::convert2Data).collect(Collectors.toList());
    }
}
