package com.maxwell.warehouse.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.maxwell.warehouse.fragments.home.ListAnimationsFragment;
import com.maxwell.warehouse.fragments.home.ListDevsFragment;
import com.maxwell.warehouse.fragments.home.ListLocationFragment;
import com.maxwell.warehouse.fragments.home.ListMultimediaFragment;
import com.maxwell.warehouse.fragments.home.ListSocialFragment;
import com.maxwell.warehouse.fragments.home.ListStorageFragment;
import com.maxwell.warehouse.fragments.home.ListUIFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbais on 25/06/2015.
 */
public class HomeAdapter extends FragmentPagerAdapter
{

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

        mListPages.add(new ListSocialFragment());
        mListPages.add(new ListMultimediaFragment());
        mListPages.add(new ListDevsFragment());
        mListPages.add(new ListUIFragment());
        mListPages.add(new ListAnimationsFragment());
        mListPages.add(new ListLocationFragment());
        mListPages.add(new ListStorageFragment());

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
