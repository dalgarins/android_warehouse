package com.maxwell.warehouse.activities.user_interface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.adapters.CardViewAdapter;
import com.maxwell.warehouse.models.CardviewModel;
import com.maxwell.warehouse.utils.SwipeableRecyclerViewTouchListener;

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
    @Bind(R.id.customRecyclerView)
    RecyclerView rv;
    CardViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_recycleview);
        ButterKnife.bind(this);

        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        initializeData();

        if(adapter != null)
            activateSwipeToLeft();
    }

    private void activateSwipeToLeft(){
        SwipeableRecyclerViewTouchListener swipeTouchListener =
                new SwipeableRecyclerViewTouchListener(rv,
                        new SwipeableRecyclerViewTouchListener.SwipeListener() {
                            @Override
                            public boolean canSwipe(int position) {
                                return true;
                            }

                            @Override
                            public void onDismissedBySwipeLeft(RecyclerView recyclerView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    itemsList.remove(position);
                                    adapter.notifyItemRemoved(position);
                                }
                                adapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onDismissedBySwipeRight(RecyclerView recyclerView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    itemsList.remove(position);
                                    adapter.notifyItemRemoved(position);
                                }
                                adapter.notifyDataSetChanged();
                            }
                        });

        rv.addOnItemTouchListener(swipeTouchListener);
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

        adapter = new CardViewAdapter(itemsList,this);
        rv.setAdapter(adapter);
    }
}
