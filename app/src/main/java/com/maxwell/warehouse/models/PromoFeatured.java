package com.maxwell.warehouse.models;

import com.maxwell.warehouse.utils.enums.InformationTypeEnum;

/**
 * Created by lbais on 20/08/2015.
 */
public class PromoFeatured extends Information{

    public PromoFeatured() {

        defineViewType();
    }

    @Override
    public void defineViewType() {

        InformationTypeEnum result = InformationTypeEnum.CARD_PROMO_FEATURED;
        this.setViewType(result.getViewTypeId());
    }
}
