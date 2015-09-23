package com.maxwell.warehouse.screens;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.fragments.ArticleFragment;

/**
 * Created by Maxwell on 22/09/2015.
 */
public class NewsFragment extends FragmentActivity {
    FragmentManager fm;
    LinearLayout listcontainer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

        listcontainer = (LinearLayout) findViewById(R.id.listcontainer);

        fm = getSupportFragmentManager();

        //replaceFragment(R.id.listcontainer);
        addFragment(new ArticleFragment());
    }

    void replaceFragment(int id){
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(id, new ArticleFragment());
        ft.commit();
    }

    void removeFragment(int id){
        Fragment fragment = fm.findFragmentById(id);
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }

    void addFragment(Fragment fragment){
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setId(R.id.action0);

        FragmentTransaction ft = fm.beginTransaction();
        ft.add(ll.getId(),fragment,"someTag");
        ft.commit();

        listcontainer.addView(ll);
    }
}
