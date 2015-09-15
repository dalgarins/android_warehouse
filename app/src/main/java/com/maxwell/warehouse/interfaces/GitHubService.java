package com.maxwell.warehouse.interfaces;

import com.maxwell.warehouse.models.GitHubUser;
import com.maxwell.warehouse.models.Podcast;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Maximiliano on 15/09/15.
 */
public interface GitHubService {
    @GET("/users/{user}")
    Call<GitHubUser> getUser(@Path("user") String user);
}
