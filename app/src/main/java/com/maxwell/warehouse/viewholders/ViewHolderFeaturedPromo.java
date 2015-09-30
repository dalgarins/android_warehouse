package com.maxwell.warehouse.viewholders;

import android.view.View;
import android.widget.ImageView;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.models.Information;

/**
 * Created by lbais on 20/08/2015.
 */
public class ViewHolderFeaturedPromo extends ViewHolderParent {
    ImageView promoBannerFeatured;

    public ViewHolderFeaturedPromo(View itemView) {
        super(itemView);
        promoBannerFeatured = (ImageView) itemView.findViewById(R.id.promoBannerFeatured);
    }

    @Override
    public void populate(Information information){
    }
}
