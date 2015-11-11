package com.maxwell.warehouse.utils;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.auth0.core.Strategies;
import com.auth0.facebook.FacebookIdentityProvider;
import com.auth0.googleplus.GooglePlusIdentityProvider;
import com.auth0.lock.Lock;
import com.auth0.lock.LockProvider;
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
public class MyApplication extends Application implements LockProvider {
    private Lock lock;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        lock = new Lock.Builder()
            .loadFromApplication(this)
            .closable(true)
            .withIdentityProvider(Strategies.Facebook, new FacebookIdentityProvider(this))
                .withIdentityProvider(Strategies.GooglePlus, new GooglePlusIdentityProvider(this))
            .build();
    }

    @Override
    public Lock getLock() {
        return lock;
    }
}
