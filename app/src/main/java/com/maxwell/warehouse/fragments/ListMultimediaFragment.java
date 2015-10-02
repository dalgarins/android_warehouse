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
import com.maxwell.warehouse.screens.AdvanceTTSAndSTT;
import com.maxwell.warehouse.screens.FacebookLogin;
import com.maxwell.warehouse.screens.FacebookShare;
import com.maxwell.warehouse.screens.GlideDemo;
import com.maxwell.warehouse.screens.MediaPlayerStreaming;
import com.maxwell.warehouse.screens.STT;
import com.maxwell.warehouse.screens.TTS;
import com.maxwell.warehouse.screens.ZoomInZoomOut;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxwell on 02/10/2015.
 */
public class ListMultimediaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Context context = container.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.base_recycleview, container, false);
        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.customRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(container.getContext(), 1));
        mRecyclerView.setHasFixedSize(false);

        List<Items> itemsList = new ArrayList<>();

        itemsList.add(new Items(MediaPlayerStreaming.class, "Media Player Streaming"));
        itemsList.add(new Items(GlideDemo.class, "Glide Demo"));
        itemsList.add(new Items(ZoomInZoomOut.class, "Zoom In Zoom Out"));
        itemsList.add(new Items(TTS.class, "TTS Example"));
        itemsList.add(new Items(STT.class, "STT Example"));
        itemsList.add(new Items(AdvanceTTSAndSTT.class, "Advance TTS & STT Example"));

        RVAdapter adapter = new RVAdapter(itemsList, getActivity());
        mRecyclerView.setAdapter(adapter);

        return v;
    }
}
