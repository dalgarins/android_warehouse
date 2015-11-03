package com.maxwell.warehouse.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.maxwell.warehouse.fragments.home.ParentListFragment;

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
            ParentListFragment socialFragment = new ParentListFragment();
            Bundle socialBundle = new Bundle();
            switch (indice) {
                case 0:
                    socialBundle.putString(ParentListFragment.TYPE, ParentListFragment.SOCIAL);
                    break;
                case 1:
                    socialBundle.putString(ParentListFragment.TYPE, ParentListFragment.MULTIMEDIA);
                    break;
                case 2:
                    socialBundle.putString(ParentListFragment.TYPE, ParentListFragment.DEVS);
                    break;
                case 3:
                    socialBundle.putString(ParentListFragment.TYPE, ParentListFragment.UI);
                    break;
                case 4:
                    socialBundle.putString(ParentListFragment.TYPE, ParentListFragment.ANIMATIONS);
                    break;
                case 5:
                    socialBundle.putString(ParentListFragment.TYPE, ParentListFragment.LOC);
                    break;
                case 6:
                    socialBundle.putString(ParentListFragment.TYPE, ParentListFragment.STORAGE);
                    break;
            }

            socialFragment.setArguments(socialBundle);
            mListPages.add(socialFragment);
        }
//        mListPages.add(new ListMultimediaFragment());
//
//        ParentListFragment parentListFragment = new ParentListFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(ParentListFragment.TYPE, ParentListFragment.DEVS);
//        parentListFragment.setArguments(bundle);
//        mListPages.add(parentListFragment);
//
//        mListPages.add(new ListUIFragment());
//        mListPages.add(new ListAnimationsFragment());
//        mListPages.add(new ListLocationFragment());
//        mListPages.add(new ListStorageFragment());

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
