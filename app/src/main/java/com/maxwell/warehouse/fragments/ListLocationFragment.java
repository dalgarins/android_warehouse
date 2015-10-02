package com.maxwell.warehouse.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.adapters.RVAdapter;
import com.maxwell.warehouse.models.Items;
import com.maxwell.warehouse.screens.ActionBarDemo;
import com.maxwell.warehouse.screens.DrawerLayoutDemo;
import com.maxwell.warehouse.screens.GoogleMapsDemo;
import com.maxwell.warehouse.screens.GoogleMapsDirections;
import com.maxwell.warehouse.screens.NewsFragment;
import com.maxwell.warehouse.screens.ParallaxDemo;
import com.maxwell.warehouse.screens.ParallaxWithCardView;
import com.maxwell.warehouse.screens.RecycleWithFactory;
import com.maxwell.warehouse.screens.SnackbarDemo;
import com.maxwell.warehouse.screens.UITesting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxwell on 02/10/2015.
 */
public class ListLocationFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Context context = container.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.base_recycleview, container, false);
        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.customRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(container.getContext(), 1));
        mRecyclerView.setHasFixedSize(false);

        List<Items> itemsList = new ArrayList<>();

        itemsList.add(new Items(GoogleMapsDemo.class, "GoogleMaps Demo"));
        itemsList.add(new Items(GoogleMapsDirections.class, "GoogleMaps Trace Route"));

        RVAdapter adapter = new RVAdapter(itemsList, getActivity());
        mRecyclerView.setAdapter(adapter);

        return v;
    }
}
