package com.maxwell.warehouse.activities.devs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.converters.ToStringConverterFactory;
import com.maxwell.warehouse.interfaces.YodaSpeakService;
import com.maxwell.warehouse.utils.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Maxwell on 14/10/2015.
 */
public class YodaSpeak extends AppCompatActivity {
    @Bind(R.id.simpleText)
    TextView simpleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_layout);
        ButterKnife.bind(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_YODA_SPEAK)
                .addConverterFactory(new ToStringConverterFactory())
                .build();

        YodaSpeakService service = retrofit.create(YodaSpeakService.class);

        Call<String> call = service.getMessage("You must be brave");

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
                simpleText.setText(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(Constants.DEBUG,t.getMessage());
            }
        });
    }
}
