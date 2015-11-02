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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maximiliano on 02/11/15.
 */
public class ParentListFragment extends Fragment {
    List<Items> itemsList = new ArrayList<>();
    RVAdapter adapter;

    public ParentListFragment() {
        adapter = new RVAdapter(itemsList, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Context context = container.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.base_recycleview, container, false);
        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.customRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(container.getContext(), 1));
        mRecyclerView.setHasFixedSize(false);

        mRecyclerView.setAdapter(adapter);

        return v;
    }

    public void populateList(List<Items> itemsList){
        this.itemsList = itemsList;

        adapter.notifyDataSetChanged();
    }
}
