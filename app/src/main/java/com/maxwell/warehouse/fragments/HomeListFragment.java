package com.maxwell.warehouse.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.activities.animations.SimpleAnimation;
import com.maxwell.warehouse.activities.devs.ButterKnifeDemo;
import com.maxwell.warehouse.activities.devs.GitHubApiDemo;
import com.maxwell.warehouse.activities.devs.GitHubApiWithVolley;
import com.maxwell.warehouse.activities.devs.TestRetrofit;
import com.maxwell.warehouse.activities.devs.YodaSpeak;
import com.maxwell.warehouse.activities.location.GoogleMapsDemo;
import com.maxwell.warehouse.activities.location.GoogleMapsDirections;
import com.maxwell.warehouse.activities.location.LocationDemo;
import com.maxwell.warehouse.activities.location.LocationListenerDemo;
import com.maxwell.warehouse.activities.multimedia.AdvanceTTSAndSTT;
import com.maxwell.warehouse.activities.multimedia.GlideDemo;
import com.maxwell.warehouse.activities.multimedia.MediaPlayerStreaming;
import com.maxwell.warehouse.activities.multimedia.ExoPlayerDemo;
import com.maxwell.warehouse.activities.multimedia.STT;
import com.maxwell.warehouse.activities.multimedia.TTS;
import com.maxwell.warehouse.activities.multimedia.VideoCaptureDemo;
import com.maxwell.warehouse.activities.multimedia.VideoStreamingDemo;
import com.maxwell.warehouse.activities.multimedia.ZoomInZoomOut;
import com.maxwell.warehouse.activities.social.FacebookLogin;
import com.maxwell.warehouse.activities.social.FacebookShare;
import com.maxwell.warehouse.activities.social.SharingDemo;
import com.maxwell.warehouse.activities.storage.FileExplorerDemo;
import com.maxwell.warehouse.activities.storage.PrefsDemo;
import com.maxwell.warehouse.activities.storage.SQLiteDemo;
import com.maxwell.warehouse.activities.storage.SaveFileDemo;
import com.maxwell.warehouse.activities.user_interface.ActionBarDemo;
import com.maxwell.warehouse.activities.user_interface.DialogDemo;
import com.maxwell.warehouse.activities.user_interface.DrawerLayoutDemo;
import com.maxwell.warehouse.activities.user_interface.FontManagerDemo;
import com.maxwell.warehouse.activities.user_interface.NewsFragment;
import com.maxwell.warehouse.activities.user_interface.ParallaxDemo;
import com.maxwell.warehouse.activities.user_interface.ParallaxWithCardView;
import com.maxwell.warehouse.activities.user_interface.RecycleWithFactory;
import com.maxwell.warehouse.activities.user_interface.ScrollBarDemo;
import com.maxwell.warehouse.activities.user_interface.SnackbarDemo;
import com.maxwell.warehouse.activities.user_interface.UITesting;
import com.maxwell.warehouse.activities.user_interface.UserList;
import com.maxwell.warehouse.adapters.RVAdapter;
import com.maxwell.warehouse.models.Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Maximiliano on 02/11/15.
 */
public class HomeListFragment extends Fragment {
    public static final String TYPE = "type";
    public static final String DEVS = "DEVS";
    public static final String SOCIAL = "SOCIAL";
    public static final String MULTIMEDIA = "MULTIMEDIA";
    public static final String UI = "UI";
    public static final String ANIMATIONS = "ANIMATIONS";
    public static final String LOC = "LOC";
    public static final String STORAGE = "STORAGE";

    protected List<Items> itemsList = new ArrayList<>();
    private RVAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new RVAdapter(new Initializator().getList(getArguments().getString(TYPE)), getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Context context = container.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.base_recycleview_wo_refresh, container, false);
        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.customRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        mRecyclerView.setHasFixedSize(false);

        mRecyclerView.setAdapter(adapter);

        return v;
    }

    public void notifyAdapter() {
        adapter.notifyDataSetChanged();
    }

    static class Initializator {
        private HashMap<String, List<Items>> hashMap = new HashMap<>();

        public Initializator() {
            populateUI();
            populateStorage();
            populateMultimedia();
            populateLocation();
            populateAnimations();
            populateSocial();
            populateDevs();
        }

        private void populateUI(){
            List<Items> uiitemsList = new ArrayList<>();
            uiitemsList.add(new Items(ParallaxDemo.class, "Parallax Demo"));
            uiitemsList.add(new Items(DrawerLayoutDemo.class, "DrawerLayout Demo"));
            uiitemsList.add(new Items(ParallaxWithCardView.class, "Parallax with CardView"));
            uiitemsList.add(new Items(SnackbarDemo.class, "Snackbar Demo"));
            uiitemsList.add(new Items(ActionBarDemo.class, "ActionBar Demo"));
            uiitemsList.add(new Items(NewsFragment.class, "Fragment Dinamico"));
            uiitemsList.add(new Items(UITesting.class, "UI Testing"));
            uiitemsList.add(new Items(RecycleWithFactory.class, "Recycle With Factory"));
            uiitemsList.add(new Items(DialogDemo.class, "Dialog With Parameters"));
            uiitemsList.add(new Items(FontManagerDemo.class, "Font Manager Demo"));
            uiitemsList.add(new Items(ScrollBarDemo.class, "ScrollBar Demo"));
            uiitemsList.add(new Items(UserList.class, "User Content Provider Custom"));
            hashMap.put(UI, uiitemsList);
        }

        private void populateStorage(){
            List<Items> storageitemsList = new ArrayList<>();
            storageitemsList.add(new Items(PrefsDemo.class, "Preferences Demo"));
            storageitemsList.add(new Items(SaveFileDemo.class, "Save File Demo"));
            storageitemsList.add(new Items(SQLiteDemo.class, "SQLite Demo"));
            storageitemsList.add(new Items(FileExplorerDemo.class, "File Explorer Demo"));
            hashMap.put(STORAGE, storageitemsList);
        }

        private void populateMultimedia(){
            List<Items> multimediaitemsList = new ArrayList<>();
            multimediaitemsList.add(new Items(MediaPlayerStreaming.class, "Media Player Streaming"));
            multimediaitemsList.add(new Items(GlideDemo.class, "Glide Demo"));
            multimediaitemsList.add(new Items(ZoomInZoomOut.class, "Zoom In Zoom Out"));
            multimediaitemsList.add(new Items(TTS.class, "TTS Example"));
            multimediaitemsList.add(new Items(STT.class, "STT Example"));
            multimediaitemsList.add(new Items(AdvanceTTSAndSTT.class, "Advance TTS & STT Example"));
            multimediaitemsList.add(new Items(VideoCaptureDemo.class, "Video Capture Demo"));
            multimediaitemsList.add(new Items(VideoStreamingDemo.class, "Video Streaming Demo"));
            multimediaitemsList.add(new Items(ExoPlayerDemo.class, "ExoPlayer Demo"));
            hashMap.put(MULTIMEDIA, multimediaitemsList);
        }

        private void populateLocation(){
            List<Items> locitemsList = new ArrayList<>();
            locitemsList.add(new Items(GoogleMapsDemo.class, "GoogleMaps Demo"));
            locitemsList.add(new Items(GoogleMapsDirections.class, "GoogleMaps Trace Route"));
            locitemsList.add(new Items(LocationDemo.class, "Location with GPS"));
            locitemsList.add(new Items(LocationListenerDemo.class, "Location Listener"));
            hashMap.put(LOC, locitemsList);
        }

        private void populateAnimations(){
            List<Items> animitemsList = new ArrayList<>();
            animitemsList.add(new Items(SimpleAnimation.class, "Simple Animation Demo"));
            hashMap.put(ANIMATIONS, animitemsList);
        }

        private void populateSocial(){
            List<Items> socialitemsList = new ArrayList<>();
            socialitemsList.add(new Items(FacebookLogin.class, "Facebook Login"));
            socialitemsList.add(new Items(FacebookShare.class, "Facebook Share"));
            socialitemsList.add(new Items(SharingDemo.class, "Sharing Demo"));
            hashMap.put(SOCIAL, socialitemsList);
        }

        private void populateDevs(){
            List<Items> devsitemsList = new ArrayList<>();
            devsitemsList.add(new Items(TestRetrofit.class, "Testing Retrofit"));
            devsitemsList.add(new Items(GitHubApiDemo.class, "GitHub Api"));
            devsitemsList.add(new Items(ButterKnifeDemo.class, "ButterKnife Demo"));
            devsitemsList.add(new Items(YodaSpeak.class, "Yoda Speak"));
            devsitemsList.add(new Items(GitHubApiWithVolley.class, "GitHub Api with Volley"));
            hashMap.put(DEVS, devsitemsList);
        }

        public List<Items> getList(String key) {
            return hashMap.get(key);
        }

    }
}
