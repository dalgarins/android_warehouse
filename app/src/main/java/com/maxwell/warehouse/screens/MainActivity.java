package com.maxwell.warehouse.screens;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.facebook.appevents.AppEventsLogger;
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
        itemsList.add(new Items(MediaPlayerStreaming.class, "Media Player Streaming"));
        itemsList.add(new Items(TestRetrofit.class, "Testing Retrofit"));
        itemsList.add(new Items(FacebookLogin.class, "Facebook Login"));
        itemsList.add(new Items(FacebookShare.class, "Facebook Share"));
        itemsList.add(new Items(GlideDemo.class, "Glide Demo"));

        RVAdapter adapter = new RVAdapter(itemsList,this);
        rv.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events. (facebook)
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event. (facebook)
        AppEventsLogger.deactivateApp(this);
    }

}
