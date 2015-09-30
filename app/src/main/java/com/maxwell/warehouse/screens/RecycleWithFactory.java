package com.maxwell.warehouse.screens;

import android.os.Bundle;
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

/**
 * Created by Maxwell on 30/09/2015.
 */
public class RecycleWithFactory extends AppCompatActivity {
    private GenericAdapterFactory adapterFactory;
    private Beneficio beneficio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_recycleview);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.customRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setHasFixedSize(false);

        List<Information> mListInformation = new ArrayList<>();

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

        GenericAdapterFactory featuredAdapter = new GenericAdapterFactory(mListInformation);
        mRecyclerView.setAdapter(featuredAdapter);
    }
}
