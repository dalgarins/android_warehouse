package com.maxwell.warehouse.interfaces;

import com.maxwell.warehouse.models.google_directions.GoogleDirections;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Maximiliano on 21/09/15.
 */
public interface GoogleMapsDirectionsService {
    @GET("/maps/api/directions/json")
    Call<GoogleDirections> getJson(@Query("origin") String origin,@Query("destination") String destination);
}
