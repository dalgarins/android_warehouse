package com.maxwell.warehouse.activities.devs;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.maxwell.warehouse.R;
import com.maxwell.warehouse.interfaces.StackOverflowAPI;
import com.maxwell.warehouse.models.Question;
import com.maxwell.warehouse.models.StackOverflowQuestions;
import com.maxwell.warehouse.utils.Constants;

import java.util.ArrayList;
import java.util.Collection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Maxwell on 12/08/2016.
 */
public class StackOverflowAPIRetrofitDemo extends ListActivity implements Callback<StackOverflowQuestions> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        requestWindowFeature(Window.FEATURE_PROGRESS);

        ArrayAdapter<Question> arrayAdapter =
                new ArrayAdapter<>(this,
                        R.layout.item_main,
                        R.id.nameItem,
                        new ArrayList<Question>());

        setListAdapter(arrayAdapter);
        setProgressBarIndeterminateVisibility(true);
        setProgressBarVisibility(true);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_STACK_OVERFLOW)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        StackOverflowAPI stackOverflowAPI = retrofit.create(StackOverflowAPI.class);

            Call<StackOverflowQuestions> call = stackOverflowAPI.loadQuestions("android");

        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<StackOverflowQuestions> call, Response<StackOverflowQuestions> response) {
        setProgressBarIndeterminateVisibility(false);
        ArrayAdapter<Question> adapter = (ArrayAdapter<Question>) getListAdapter();
        adapter.clear();
        adapter.addAll(response.body().items);
    }

    @Override
    public void onFailure(Call<StackOverflowQuestions> call, Throwable t) {
        Toast.makeText(StackOverflowAPIRetrofitDemo.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
}
