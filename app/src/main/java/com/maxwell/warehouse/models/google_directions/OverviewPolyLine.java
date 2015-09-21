package com.maxwell.warehouse.models.google_directions;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Maximiliano on 21/09/15.
 */
public class OverviewPolyLine {
    @SerializedName("points")
    public String points;

    public String getPoints() {
        return points;
    }
}
