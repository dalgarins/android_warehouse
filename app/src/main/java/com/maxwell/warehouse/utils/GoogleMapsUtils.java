package com.maxwell.warehouse.utils;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Maxwell on 17/09/2015.
 */
public class GoogleMapsUtils {
    public static void addMarkerToMap(GoogleMap map,double lat,double lng,String title, int icon){
        BitmapDescriptor markerIcon = BitmapDescriptorFactory.fromResource(icon);

        map.addMarker(new MarkerOptions()
                .position(new LatLng(lat, lng))
                .title(title)
                .icon(markerIcon));
    }
}
