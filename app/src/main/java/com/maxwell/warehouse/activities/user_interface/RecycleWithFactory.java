package com.maxwell.warehouse.activities.user_interface;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.adapters.GenericAdapterFactory;
import com.maxwell.warehouse.models.Beneficio;
import com.maxwell.warehouse.models.Information;
import com.maxwell.warehouse.models.PromoFeatured;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Maxwell on 30/09/2015.
 */
public class RecycleWithFactory extends AppCompatActivity {
    private GenericAdapterFactory adapterFactory;
    private Beneficio beneficio;
    List<Information> mListInformation = new ArrayList<>();
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.customRecyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_recycleview);
        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setHasFixedSize(false);

        adapterFactory = new GenericAdapterFactory(mListInformation);
        mRecyclerView.setAdapter(adapterFactory);

        loadInfo();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadInfo();
            }
        });
    }

    private void loadInfo(){
        mListInformation.clear();

        mListInformation.add(new PromoFeatured());
        mListInformation.add(new PromoFeatured());

        for(int i=0; i< 5; i++){
            if(i % 2 == 0){
                mListInformation.add(new Beneficio("Titulo", "Texto", true));
            }else{
                mListInformation.add(new Beneficio("Titulo", "Texto", false));
            }
        }

        mListInformation.add(new PromoFeatured());

        adapterFactory.notifyDataSetChanged();

        swipeRefreshLayout.setRefreshing(false);
    }
}
