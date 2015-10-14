package com.maxwell.warehouse.interfaces;

import com.maxwell.warehouse.models.GitHubUser;
import com.maxwell.warehouse.utils.Constants;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Maximiliano on 15/09/15.
 */
public interface YodaSpeakService {
    @Headers({
            "X-Mashape-Key: " + Constants.KEY_MASHAPE
            //"Accept: text/plain"
    })
    @GET("/yoda")
    Call<String> getMessage(@Query("sentence") String message);
}
