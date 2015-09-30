package com.maxwell.warehouse.models;

/**
 * Created by Maxwell on 30/09/2015.
 */
public abstract class Information
{
    private int viewType;
    public int getViewType(){
        return viewType;
    }
    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
    public abstract void defineViewType();

}
