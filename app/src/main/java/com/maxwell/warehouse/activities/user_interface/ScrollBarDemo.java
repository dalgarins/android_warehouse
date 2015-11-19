package com.maxwell.warehouse.activities.user_interface;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.adapters.GenericAdapterFactory;
import com.maxwell.warehouse.models.Beneficio;
import com.maxwell.warehouse.models.Information;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxwell on 08/10/2015.
 */
public class ScrollBarDemo extends AppCompatActivity {
    private GenericAdapterFactory adapterFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollbar_layout);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.customRecyclerViewScroll);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setHasFixedSize(false);

        List<Information> mListInformation = new ArrayList<>();

        for(int i=0; i< 10; i++){
            if(i % 2 == 0){
                mListInformation.add(new Beneficio("Titulo", "Texto", true));
            }else{
                mListInformation.add(new Beneficio("Titulo", "Texto", false));
            }
        }

        GenericAdapterFactory featuredAdapter = new GenericAdapterFactory(mListInformation);
        mRecyclerView.setAdapter(featuredAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.customToolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        if(actionBar!=null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
