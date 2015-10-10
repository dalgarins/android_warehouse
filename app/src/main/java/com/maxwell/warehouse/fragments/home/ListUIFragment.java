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
import com.maxwell.warehouse.screens.ActionBarDemo;
import com.maxwell.warehouse.screens.ButterKnifeDemo;
import com.maxwell.warehouse.screens.DialogDemo;
import com.maxwell.warehouse.screens.DrawerLayoutDemo;
import com.maxwell.warehouse.screens.FontManagerDemo;
import com.maxwell.warehouse.screens.GitHubApiDemo;
import com.maxwell.warehouse.screens.NewsFragment;
import com.maxwell.warehouse.screens.ParallaxDemo;
import com.maxwell.warehouse.screens.ParallaxWithCardView;
import com.maxwell.warehouse.screens.RecycleWithFactory;
import com.maxwell.warehouse.screens.ScrollBarDemo;
import com.maxwell.warehouse.screens.SnackbarDemo;
import com.maxwell.warehouse.screens.TestRetrofit;
import com.maxwell.warehouse.screens.UITesting;
import com.maxwell.warehouse.utils.FontManger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxwell on 02/10/2015.
 */
public class ListUIFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Context context = container.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.base_recycleview, container, false);
        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.customRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(container.getContext(), 1));
        mRecyclerView.setHasFixedSize(false);

        List<Items> itemsList = new ArrayList<>();

        itemsList.add(new Items(ParallaxDemo.class, "Parallax Demo"));
        itemsList.add(new Items(DrawerLayoutDemo.class, "DrawerLayout Demo"));
        itemsList.add(new Items(ParallaxWithCardView.class, "Parallax with CardView"));
        itemsList.add(new Items(SnackbarDemo.class, "Snackbar Demo"));
        itemsList.add(new Items(ActionBarDemo.class, "ActionBar Demo"));
        itemsList.add(new Items(NewsFragment.class, "Fragment Dinamico"));
        itemsList.add(new Items(UITesting.class, "UI Testing"));
        itemsList.add(new Items(RecycleWithFactory.class, "Recycle With Factory"));
        itemsList.add(new Items(DialogDemo.class, "Dialog With Parameters"));
        itemsList.add(new Items(FontManagerDemo.class, "Font Manager Demo"));
        itemsList.add(new Items(ScrollBarDemo.class, "ScrollBar Demo"));

        RVAdapter adapter = new RVAdapter(itemsList, getActivity());
        mRecyclerView.setAdapter(adapter);

        return v;
    }
}
