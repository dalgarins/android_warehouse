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
import com.maxwell.warehouse.activities.devs.GitHubApiWithVolley;
import com.maxwell.warehouse.activities.devs.YodaSpeak;
import com.maxwell.warehouse.adapters.RVAdapter;
import com.maxwell.warehouse.models.Items;
import com.maxwell.warehouse.activities.devs.ButterKnifeDemo;
import com.maxwell.warehouse.activities.devs.GitHubApiDemo;
import com.maxwell.warehouse.activities.devs.TestRetrofit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxwell on 02/10/2015.
 */
public class ListDevsFragment extends ParentListFragment {
    List<Items> singleItemList = new ArrayList<>();

    public ListDevsFragment(){
        singleItemList.add(new Items(TestRetrofit.class, "Testing Retrofit"));
        singleItemList.add(new Items(GitHubApiDemo.class, "GitHub Api"));
        singleItemList.add(new Items(ButterKnifeDemo.class, "ButterKnife Demo"));
        singleItemList.add(new Items(YodaSpeak.class, "Yoda Speak"));
        singleItemList.add(new Items(GitHubApiWithVolley.class, "GitHub Api with Volley"));

        populateList(singleItemList);
    }
}
