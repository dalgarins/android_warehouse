package com.maxwell.warehouse.models;

import com.maxwell.warehouse.viewholders.ViewHolderParent;

/**
 * Created by Maxwell on 01/11/2015.
 */
public class ViewHolderModel {
    private int layout;
    private ViewHolderParent viewHolder;

    public ViewHolderModel(int layout, ViewHolderParent viewHolder) {
        this.layout = layout;
        this.viewHolder = viewHolder;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public ViewHolderParent getViewHolder() {
        return viewHolder;
    }

    public void setViewHolder(ViewHolderParent viewHolder) {
        this.viewHolder = viewHolder;
    }
}
