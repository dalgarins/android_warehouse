package com.maxwell.warehouse.screens;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.interfaces.LevaduraPodService;
import com.maxwell.warehouse.models.Podcast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Maximiliano on 15/09/15.
 */
public class TestRetrofit extends ListActivity {
    String API = "http://api.levadura.argentinageek.net";
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_podcast);

        list = new ArrayList<>();

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

                for(int i = 0; i < response.body().size(); i++){
                    list.add(response.body().get(i).getDescripcion());
                }

                ArrayAdapter<String> myAdapter = new ArrayAdapter <>(TestRetrofit.this,
                        R.layout.item_main, R.id.nameItem, list);

                setListAdapter(myAdapter);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("debug_log", "falla");
            }
        });
    }
}
