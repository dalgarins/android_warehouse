package com.maxwell.warehouse.screens;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.maxwell.warehouse.R;
import com.maxwell.warehouse.interfaces.GoogleMapsDirectionsService;
import com.maxwell.warehouse.models.google_directions.GoogleDirections;
import com.maxwell.warehouse.models.google_directions.Location;
import com.maxwell.warehouse.models.google_directions.Route;
import com.maxwell.warehouse.models.google_directions.Steps;
import com.maxwell.warehouse.utils.Constants;
import com.maxwell.warehouse.utils.GoogleMapsUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class GoogleMapsDirections extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps_demo);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        mMap.setMyLocationEnabled(true);

        UiSettings uiSettings = mMap.getUiSettings();

        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setCompassEnabled(true);
        uiSettings.setMapToolbarEnabled(true);

        setUpDirections();
    }

    private void setUpDirections(){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_GOOGLE_MAPS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GoogleMapsDirectionsService service = retrofit.create(GoogleMapsDirectionsService.class);
        Call<GoogleDirections> call = service.getJson("-34.5959814,-58.3925538","-34.5671434,-58.6983834");

        call.enqueue(new Callback<GoogleDirections>() {
            @Override
            public void onResponse(Response<GoogleDirections> response) {
                GoogleDirections directionResults = response.body();

                ArrayList<LatLng> routelist = new ArrayList<>();
                if(directionResults.getRoutes().size()>0){
                    ArrayList<LatLng> decodelist;
                    Route routeA = directionResults.getRoutes().get(0);
                    if(routeA.getLegs().size()>0){
                        List<Steps> steps= routeA.getLegs().get(0).getSteps();
                        Steps step;
                        Location location;
                        String polyline;
                        for(int i=0 ; i<steps.size();i++){
                            step = steps.get(i);
                            location =step.getStart_location();
                            routelist.add(new LatLng(location.getLat(), location.getLng()));
                            polyline = step.getPolyline().getPoints();
                            decodelist = GoogleMapsUtils.decodePoly(polyline);
                            routelist.addAll(decodelist);
                            location =step.getEnd_location();
                            routelist.add(new LatLng(location.getLat(), location.getLng()));
                        }
                    }
                }
                if(routelist.size()>0){
                    PolylineOptions rectLine = new PolylineOptions().width(10).color(
                            Color.RED);

                    for (int i = 0; i < routelist.size(); i++) {
                        rectLine.add(routelist.get(i));
                    }
                    // Adding route on the map
                    mMap.addPolyline(rectLine);
                    MarkerOptions marker = new MarkerOptions();
                    marker.position(new LatLng(-34.5671434,-58.6983834));
                    mMap.addMarker(marker);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Failure, retrofitError" + t.getMessage());
            }
        });
    }
}
