package com.maxwell.warehouse.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxwell.warehouse.R;
import com.maxwell.warehouse.models.Beneficio;
import com.maxwell.warehouse.models.Information;

/**
 * Created by Maxwell on 30/09/2015.
 */
public class ViewHolderBenefitWithDistance extends ViewHolderParent {
    private TextView brandName, benefitDescription, distance, benefitByCardText;
    private ImageView benefitPhoto;

    public ViewHolderBenefitWithDistance(View itemView) {
        super(itemView);

        brandName = (TextView)itemView.findViewById(R.id.brandName);
        //distance = (TextView) itemView.findViewById(R.id.distance);
        benefitDescription = (TextView) itemView.findViewById(R.id.benefitDescription);
        benefitPhoto = (ImageView) itemView.findViewById(R.id.benefitPhoto);
        benefitByCardText = (TextView) itemView.findViewById(R.id.benefitBasicCardText);
    }

    @Override
    public void populate(Information information) {
        final Beneficio beneficio = (Beneficio) information;

        //brandName.setText(beneficio.getBrandName());
        benefitDescription.setText(beneficio.getBenefitText());

        if(beneficio.getBenefitPhoto()!=null && !beneficio.getBenefitPhoto().isEmpty())
            Glide.with(context).load(beneficio.getBenefitPhoto()).placeholder(R.drawable.fenix).into(benefitPhoto);
    }

}
