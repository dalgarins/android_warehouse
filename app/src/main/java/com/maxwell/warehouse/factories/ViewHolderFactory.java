package com.maxwell.warehouse.factories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.models.Information;
import com.maxwell.warehouse.utils.enums.InformationTypeEnum;
import com.maxwell.warehouse.viewholders.ViewHolderBenefitNoDistance;
import com.maxwell.warehouse.viewholders.ViewHolderBenefitWithDistance;
import com.maxwell.warehouse.viewholders.ViewHolderFeaturedPromo;
import com.maxwell.warehouse.viewholders.ViewHolderParent;

/**
 * Created by Maxwell on 30/09/2015.
 */
public class ViewHolderFactory {

    public static ViewHolderParent create(ViewGroup parent, int viewType) {
        ViewHolderParent vh = null;
        View v;

        switch (InformationTypeEnum.getEnum(viewType))
        {
            case CARD_BENEFIT_WITH_DISTANCE:{
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_benefit_with_distance, parent, false);
                vh = new ViewHolderBenefitWithDistance(v);
                break;
            }
            case CARD_BENEFIT_BIG:{
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_benefit_big, parent, false);
                vh = new ViewHolderBenefitNoDistance(v);
                break;
            }
            case CARD_PROMO_FEATURED:{
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_promo_featured, parent, false);
                vh = new ViewHolderFeaturedPromo(v);
                break;
            }
            default:{
                vh = null;
                break;
            }
        }

        return vh;
    }

    public static void populate(ViewHolderParent holder, Information information) {

        //TODO refactor to extend of generic populate.
        switch (InformationTypeEnum.getEnum(information.getViewType())){
            case CARD_BENEFIT_BIG:
            case CARD_BENEFIT_WITH_DISTANCE:
            case CARD_FAVORITES:
                break;
        }
        holder.populate(information);
    }
}
