package com.maxwell.warehouse.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.maxwell.warehouse.models.Information;

/**
 * Created by Maxwell on 30/09/2015.
 */
public abstract class ViewHolderParent extends RecyclerView.ViewHolder{

    protected Context context;

    public ViewHolderParent(View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    public abstract void populate(Information information);

}
