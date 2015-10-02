package com.maxwell.warehouse.screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.appevents.AppEventsLogger;
import com.maxwell.warehouse.R;
import com.maxwell.warehouse.adapters.RVAdapter;
import com.maxwell.warehouse.models.Items;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    List<Items> itemsList = new ArrayList<>();
    RecyclerView rv;
    @Bind(R.id.buttonsContainer)
    LinearLayout buttonsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        buttonsContainer.setVisibility(View.GONE);

        initializeData();
    }

    private void initializeData() {
        //SOCIAL
        itemsList.add(new Items(FacebookLogin.class, "Facebook Login"));
        itemsList.add(new Items(FacebookShare.class, "Facebook Share"));
        //MULTIMEDIA
        itemsList.add(new Items(MediaPlayerStreaming.class, "Media Player Streaming"));
        itemsList.add(new Items(GlideDemo.class, "Glide Demo"));
        itemsList.add(new Items(ZoomInZoomOut.class, "Zoom In Zoom Out"));
        itemsList.add(new Items(TTS.class, "TTS Example"));
        itemsList.add(new Items(STT.class, "STT Example"));
        itemsList.add(new Items(AdvanceTTSAndSTT.class, "Advance TTS & STT Example"));
        //DEVS
        itemsList.add(new Items(TestRetrofit.class, "Testing Retrofit"));
        itemsList.add(new Items(GitHubApiDemo.class, "GitHub Api"));
        itemsList.add(new Items(ButterKnifeDemo.class, "ButterKnife Demo"));
        //UI
        itemsList.add(new Items(ParallaxDemo.class, "Parallax Demo"));
        itemsList.add(new Items(DrawerLayoutDemo.class, "DrawerLayout Demo"));
        itemsList.add(new Items(ParallaxWithCardView.class, "Parallax with CardView"));
        itemsList.add(new Items(SnackbarDemo.class, "Snackbar Demo"));
        itemsList.add(new Items(ActionBarDemo.class, "ActionBar Demo"));
        itemsList.add(new Items(NewsFragment.class, "Fragment Dinamico"));
        itemsList.add(new Items(UITesting.class, "UI Testing"));
        itemsList.add(new Items(RecycleWithFactory.class, "Recycle With Factory"));
        //LOCALIZACION
        itemsList.add(new Items(GoogleMapsDemo.class, "GoogleMaps Demo"));
        itemsList.add(new Items(GoogleMapsDirections.class, "GoogleMaps Trace Route"));
        //STORAGE
        itemsList.add(new Items(PrefsDemo.class, "Preferences Demo"));
        itemsList.add(new Items(SaveFileDemo.class, "Save File Demo"));
        //ANIMACIONES
        itemsList.add(new Items(SimpleAnimation.class, "Simple Animation Demo"));

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
