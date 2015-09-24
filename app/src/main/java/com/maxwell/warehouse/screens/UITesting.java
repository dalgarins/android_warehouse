package com.maxwell.warehouse.screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.adapters.CardViewAdapter;
import com.maxwell.warehouse.models.CardviewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Maximiliano on 24/09/15.
 */
public class UITesting extends AppCompatActivity {
    List<CardviewModel> itemsList = new ArrayList<>();
    @Bind(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        initializeData();
    }

    private void initializeData() {
        String[] frasesList = getResources().getStringArray(R.array.frases);
        String[] imagesList = getResources().getStringArray(R.array.imagenes);

        for (int i = 0; i < 20; i++) {
            Random r = new Random();
            int numberTitle = r.nextInt(frasesList.length);
            int numberDesc = r.nextInt(frasesList.length);
            int numberImages = r.nextInt(imagesList.length);

            CardviewModel item = new CardviewModel(imagesList[numberImages], frasesList[numberTitle], frasesList[numberDesc]);

            itemsList.add(item);
        }

        CardViewAdapter adapter = new CardViewAdapter(itemsList,this);
        rv.setAdapter(adapter);
    }
}
