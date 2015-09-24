package com.maxwell.warehouse.screens;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.facebook.appevents.AppEventsLogger;
import com.maxwell.warehouse.R;
import com.maxwell.warehouse.adapters.RVAdapter;
import com.maxwell.warehouse.models.Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    List<Items> itemsList = new ArrayList<>();
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        initializeData();
    }

    private void initializeData() {
        itemsList.add(new Items(MediaPlayerStreaming.class, "Media Player Streaming"));
        itemsList.add(new Items(TestRetrofit.class, "Testing Retrofit"));
        itemsList.add(new Items(FacebookLogin.class, "Facebook Login"));
        itemsList.add(new Items(FacebookShare.class, "Facebook Share"));
        itemsList.add(new Items(GlideDemo.class, "Glide Demo"));
        itemsList.add(new Items(ZoomInZoomOut.class, "Zoom In Zoom Out"));
        itemsList.add(new Items(GitHubApiDemo.class, "GitHub Api"));
        itemsList.add(new Items(TTS.class, "TTS Example"));
        itemsList.add(new Items(STT.class, "STT Example"));
        itemsList.add(new Items(ButterKnifeDemo.class, "ButterKnife Demo"));
        itemsList.add(new Items(ParallaxDemo.class, "Parallax Demo"));
        itemsList.add(new Items(DrawerLayoutDemo.class, "DrawerLayout Demo"));
        itemsList.add(new Items(GoogleMapsDemo.class, "GoogleMaps Demo"));
        itemsList.add(new Items(GoogleMapsDirections.class, "GoogleMaps Trace Route"));
        itemsList.add(new Items(ParallaxWithCardView.class, "Parallax with CardView"));
        itemsList.add(new Items(SnackbarDemo.class, "Snackbar Demo"));
        itemsList.add(new Items(ActionBarDemo.class, "ActionBar Demo"));
        itemsList.add(new Items(NewsFragment.class, "Fragment Dinamico"));

        RVAdapter adapter = new RVAdapter(itemsList, this);
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
