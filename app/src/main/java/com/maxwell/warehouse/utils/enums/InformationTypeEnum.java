package com.maxwell.warehouse.utils.enums;

/**
 * Created by Maxwell on 30/09/2015.
 */
public enum InformationTypeEnum {
    INFORMATION(1), CARD_BENEFIT_WITH_DISTANCE(2), CARD_BENEFIT_BIG(3), CARD_FAVORITES(4), CARD_PROMO_FEATURED(5);
    private int viewTypeId;

    InformationTypeEnum(int viewTypeId){
        this.viewTypeId = viewTypeId;
    }

    public int getViewTypeId() {
        return viewTypeId;
    }

    public static InformationTypeEnum getEnum(int value){
        for (InformationTypeEnum e : InformationTypeEnum.values()){
            if (e.getViewTypeId() == value){
                return e;
            }
        }

        throw new RuntimeException("El parametro value no corresponde que ningun valor de los enums: " + value);

    }
}
