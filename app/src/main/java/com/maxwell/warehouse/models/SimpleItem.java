package com.maxwell.warehouse.models;

import com.maxwell.warehouse.utils.enums.InformationTypeEnum;

/**
 * Created by Maximiliano on 29/07/15.
 */
public class SimpleItem extends Information{
    String nameItem;

    public SimpleItem(String nameItem){
        defineViewType();
        this.nameItem = nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    @Override
    public void defineViewType() {
        InformationTypeEnum result = InformationTypeEnum.SIMPLE_ITEM;
        this.setViewType(result.getViewTypeId());
    }
}
