package com.maxwell.warehouse.interfaces;

import com.maxwell.warehouse.models.Podcast;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Maximiliano on 15/09/15.
 */
public interface LevaduraPodService {
    @GET("/episodios/all")
    Call<List<Podcast>> getFeed();
}
