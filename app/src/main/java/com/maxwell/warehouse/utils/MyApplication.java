package com.maxwell.warehouse.utils;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.models.ViewHolderModel;
import com.maxwell.warehouse.utils.enums.InformationTypeEnum;
import com.maxwell.warehouse.viewholders.ViewHolderBenefitWithDistance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Maxwell on 10/10/2015.
 */
public class MyApplication extends Application {
    Map<Enum, ViewHolderModel> viewHolders = new HashMap<>();

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //viewHolders.put(InformationTypeEnum.CARD_BENEFIT_WITH_DISTANCE,
        //        new ViewHolderModel(R.layout.card_benefit_with_distance,
        //            ViewHolderBenefitWithDistance.class));
    }
}
