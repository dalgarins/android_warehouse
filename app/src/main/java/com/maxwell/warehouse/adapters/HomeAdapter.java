package com.maxwell.warehouse.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.maxwell.warehouse.fragments.HomeListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbais on 25/06/2015.
 */
public class HomeAdapter extends FragmentPagerAdapter {

    private List<Fragment> mListPages;

    private String[] titles = new String[]{
            "Social",
            "Multimedia",
            "Devs",
            "User Interface",
            "Animations",
            "Location",
            "Storage"
    };

    public HomeAdapter(FragmentManager fm) {
        super(fm);

        mListPages = new ArrayList<>();

        for (int indice = 0; indice < 7; indice++) {
            HomeListFragment socialFragment = new HomeListFragment();
            Bundle socialBundle = new Bundle();
            switch (indice) {
                case 0:
                    socialBundle.putString(HomeListFragment.TYPE, HomeListFragment.SOCIAL);
                    break;
                case 1:
                    socialBundle.putString(HomeListFragment.TYPE, HomeListFragment.MULTIMEDIA);
                    break;
                case 2:
                    socialBundle.putString(HomeListFragment.TYPE, HomeListFragment.DEVS);
                    break;
                case 3:
                    socialBundle.putString(HomeListFragment.TYPE, HomeListFragment.UI);
                    break;
                case 4:
                    socialBundle.putString(HomeListFragment.TYPE, HomeListFragment.ANIMATIONS);
                    break;
                case 5:
                    socialBundle.putString(HomeListFragment.TYPE, HomeListFragment.LOC);
                    break;
                case 6:
                    socialBundle.putString(HomeListFragment.TYPE, HomeListFragment.STORAGE);
                    break;
            }

            socialFragment.setArguments(socialBundle);
            mListPages.add(socialFragment);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mListPages.get(position);
    }

    @Override
    public int getCount() {
        return mListPages.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
