package com.maxwell.warehouse.screens;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.maxwell.warehouse.R;

/**
 * Created by Maxwell on 22/09/2015.
 */
public class NewsFragment extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);
    }
}
