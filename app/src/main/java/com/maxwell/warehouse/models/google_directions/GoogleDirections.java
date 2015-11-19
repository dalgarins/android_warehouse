package com.maxwell.warehouse.models.google_directions;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Maximiliano on 21/09/15.
 */
public class GoogleDirections {
    @SerializedName("routes")
    private List<Route> routes;

    public List<Route> getRoutes() {
        return routes;
    }
}