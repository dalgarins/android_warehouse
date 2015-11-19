package com.maxwell.warehouse.models.google_directions;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Maximiliano on 21/09/15.
 */
public class Route {
    @SerializedName("overview_polyline")
    private OverviewPolyLine overviewPolyLine;

    private List<Legs> legs;

    public OverviewPolyLine getOverviewPolyLine() {
        return overviewPolyLine;
    }

    public List<Legs> getLegs() {
        return legs;
    }
}
