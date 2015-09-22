package com.maxwell.warehouse.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxwell.warehouse.R;

/**
 * Created by Maxwell on 22/09/2015.
 */
public class ArticleFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.simple_layout, container, false);
    }
}
