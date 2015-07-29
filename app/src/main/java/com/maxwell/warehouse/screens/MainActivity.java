package com.maxwell.warehouse.screens;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.adapters.RVAdapter;
import com.maxwell.warehouse.models.Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends Activity {
    List<Items> itemsList = new ArrayList<>();
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        initializeData();
    }

    private void initializeData(){
        HashMap<Class, String> itemHashMapList = new HashMap<>();
        itemHashMapList.put(MediaPlayerStreaming.class,"Media Player Streaming");

        for (HashMap.Entry<Class, String> entry : itemHashMapList.entrySet()) {
            Items items = new Items();
            items.setClassItem(entry.getKey());
            items.setNameItem(entry.getValue());

            itemsList.add(items);
        }

        RVAdapter adapter = new RVAdapter(itemsList,this);
        rv.setAdapter(adapter);
    }

}
