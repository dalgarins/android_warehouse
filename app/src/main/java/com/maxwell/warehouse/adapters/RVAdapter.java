package com.maxwell.warehouse.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maxwell.warehouse.R;
import com.maxwell.warehouse.models.Items;

import java.util.List;

/**
 * Created by Maximiliano on 29/07/15.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ItemViewHolder>{
    List<Items> itemsList;
    Context ctx;

    public RVAdapter(List<Items> itemsList,Context ctx){
        this.itemsList = itemsList;
        this.ctx = ctx;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main, viewGroup, false);
        ItemViewHolder pvh = new ItemViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final Class className = itemsList.get(position).getClassItem();

        holder.nameItem.setText(itemsList.get(position).getNameItem());

        holder.rlItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ctx,className);
                ctx.startActivity(i);
            }
        });
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
        TextView nameItem;
        RelativeLayout rlItem;

        ItemViewHolder(View itemView) {
            super(itemView);
            nameItem = (TextView)itemView.findViewById(R.id.nameItem);
            rlItem = (RelativeLayout)itemView.findViewById(R.id.rlItem);
        }
    }
}
