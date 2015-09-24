package com.maxwell.warehouse.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maxwell.warehouse.R;
import com.maxwell.warehouse.models.CardviewModel;
import com.maxwell.warehouse.models.Items;

import java.util.List;

/**
 * Created by Maximiliano on 29/07/15.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ItemViewHolder>{
    List<CardviewModel> itemsList;
    Context ctx;

    public CardViewAdapter(List<CardviewModel> itemsList, Context ctx){
        this.itemsList = itemsList;
        this.ctx = ctx;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview, viewGroup, false);
        ItemViewHolder pvh = new ItemViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Glide.with(ctx).load(itemsList.get(position).getImgUrl()).into(holder.imageCardViewUI);

        holder.titleCardViewUI.setText(itemsList.get(position).getTitle());
        holder.descCardViewUI.setText(itemsList.get(position).getDescription());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageCardViewUI;
        TextView titleCardViewUI, descCardViewUI;
        CardView cardViewUI;

        ItemViewHolder(View itemView) {
            super(itemView);
            imageCardViewUI = (ImageView) itemView.findViewById(R.id.imageCardViewUI);
            titleCardViewUI = (TextView)itemView.findViewById(R.id.titleCardViewUI);
            descCardViewUI = (TextView)itemView.findViewById(R.id.descCardViewUI);
            cardViewUI = (CardView)itemView.findViewById(R.id.cardView);
        }
    }
}
