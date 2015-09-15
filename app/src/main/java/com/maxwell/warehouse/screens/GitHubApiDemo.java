package com.maxwell.warehouse.screens;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.interfaces.GitHubService;
import com.maxwell.warehouse.models.GitHubUser;
import com.maxwell.warehouse.utils.Constants;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Maximiliano on 15/09/15.
 */
public class GitHubApiDemo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_GITHUB)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);
        Call<GitHubUser> call = gitHubService.getUser("maxwellnewage");


        call.enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(Response<GitHubUser> response) {
                // Get result Repo from response.body()
                Log.i("debug_log", "nada");
                //TODO mostrarlo, ahora no tengo ganas :D, pero funciona xD
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("debug_log", "falla");
            }
        });
    }
}
