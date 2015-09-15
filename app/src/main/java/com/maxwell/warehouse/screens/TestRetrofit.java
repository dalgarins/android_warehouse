package com.maxwell.warehouse.screens;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.interfaces.LevaduraPodService;
import com.maxwell.warehouse.models.Podcast;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Maximiliano on 15/09/15.
 */
public class TestRetrofit extends Activity {
    String API = "http://api.levadura.argentinageek.net";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LevaduraPodService service = retrofit.create(LevaduraPodService.class);

        Call<List<Podcast>> call = service.getFeed();

        call.enqueue(new Callback<List<Podcast>>() {
            @Override
            public void onResponse(Response<List<Podcast>> response) {
                // Get result Repo from response.body()
                Log.i("debug_log", "nada");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("debug_log", "falla");
            }
        });
    }
}
