package com.maxwell.warehouse.viewholders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxwell.warehouse.R;
import com.maxwell.warehouse.models.Beneficio;
import com.maxwell.warehouse.models.Information;

/**
 * Created by lbais on 20/08/2015.
 */
public class ViewHolderBenefitNoDistance extends ViewHolderParent {

    private TextView brandName, benefitDescription, benefitByCardText;
    private ImageView benefitPhoto;

    public ViewHolderBenefitNoDistance(View itemView) {
        super(itemView);

        brandName = (TextView)itemView.findViewById(R.id.brandName);
        benefitDescription = (TextView) itemView.findViewById(R.id.benefitDescription);
        benefitPhoto = (ImageView) itemView.findViewById(R.id.benefitPhoto);
        benefitByCardText = (TextView) itemView.findViewById(R.id.benefitBasicCardText);
    }

    @Override
    public void populate(Information information){
        final Beneficio beneficio = (Beneficio) information;

        brandName.setText(beneficio.getBrandName());
        benefitDescription.setText(beneficio.getBenefitText());

        if(beneficio.getBenefitPhoto()!=null && !beneficio.getBenefitPhoto().isEmpty())
            Glide.with(context).load(beneficio.getBenefitPhoto()).placeholder(R.drawable.fenix).into(benefitPhoto);
    }

}
