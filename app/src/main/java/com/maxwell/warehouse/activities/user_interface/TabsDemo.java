package com.maxwell.warehouse.activities.user_interface;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.appevents.AppEventsLogger;
import com.maxwell.warehouse.R;
import com.maxwell.warehouse.adapters.HomeAdapter;
import com.maxwell.warehouse.models.Items;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class TabsDemo extends AppCompatActivity {
    List<Items> itemsList = new ArrayList<>();
    @Bind(R.id.buttonsContainer)
    LinearLayout buttonsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs_layout);
        ButterKnife.bind(this);

        buttonsContainer.setVisibility(View.GONE);

        ViewPager viewPager = (ViewPager) findViewById(R.id.customViewPager);
        HomeAdapter homeAdapter = new HomeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(homeAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.designTabLayout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events. (facebook)
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event. (facebook)
        AppEventsLogger.deactivateApp(this);
    }


}
