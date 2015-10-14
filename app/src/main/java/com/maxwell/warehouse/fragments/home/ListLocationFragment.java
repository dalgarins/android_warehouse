package com.maxwell.warehouse.fragments.home;

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
import com.maxwell.warehouse.activities.location.GoogleMapsDemo;
import com.maxwell.warehouse.activities.location.GoogleMapsDirections;
import com.maxwell.warehouse.activities.location.LocationDemo;
import com.maxwell.warehouse.activities.location.LocationListenerDemo;

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
        itemsList.add(new Items(LocationDemo.class, "Location with GPS"));
        itemsList.add(new Items(LocationListenerDemo.class, "Location Listener"));

        RVAdapter adapter = new RVAdapter(itemsList, getActivity());
        mRecyclerView.setAdapter(adapter);

        return v;
    }
}