package com.aliaszen.code.gen.enums;

import com.aliaszen.code.gen.dto.DictKeyValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * generic enum interface
 *
 * @author Alias Zen
 * @version 1.0
 * @since 2023-01-05
 */
public interface GenericEnum<T extends Serializable,U extends Serializable> extends CodeEnum<T> {

    U getText();

    static List<DictKeyValue> toDictKeyValue(GenericEnum<String,String>[] arr){
        List<DictKeyValue> dtos = new ArrayList<>(arr.length);

        for (GenericEnum<String,String> item: arr){
            DictKeyValue dictKeyValue = new DictKeyValue();
            dictKeyValue.setItemValue(item.getValue());
            dictKeyValue.setItemText(item.getText());
            dtos.add(dictKeyValue);
        }
        return dtos;
    }
}
