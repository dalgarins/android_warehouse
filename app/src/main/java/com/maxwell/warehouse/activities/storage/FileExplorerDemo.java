package com.maxwell.warehouse.activities.storage;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.adapters.CardViewAdapter;
import com.maxwell.warehouse.adapters.GenericAdapterFactory;
import com.maxwell.warehouse.models.CardviewModel;
import com.maxwell.warehouse.models.Information;
import com.maxwell.warehouse.models.SimpleItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Maximiliano on 02/11/15.
 */
public class FileExplorerDemo extends AppCompatActivity {
    List<Information> mListInformation = new ArrayList<>();
    @Bind(R.id.customRecyclerView)
    RecyclerView rv;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    private GenericAdapterFactory adapterFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_recycleview);
        ButterKnife.bind(this);

        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        adapterFactory = new GenericAdapterFactory(mListInformation);
        rv.setAdapter(adapterFactory);

        buildFilesList();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                buildFilesList();
            }
        });
    }

    private void buildFilesList() {
        mListInformation.clear();

        String path = Environment.getExternalStorageDirectory().toString();
        File f = new File(path);
        File file[] = f.listFiles();
        for (int i=0; i < file.length; i++)
        {
            mListInformation.add(new SimpleItem(file[i].getName()));
        }

        adapterFactory.notifyDataSetChanged();

        swipeRefreshLayout.setRefreshing(false);
    }
}
