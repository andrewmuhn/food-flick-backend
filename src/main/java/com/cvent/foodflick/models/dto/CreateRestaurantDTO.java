package com.cvent.foodflick.models.dto;

import com.cvent.foodflick.models.YelpMetaData;

public class CreateRestaurantDTO {

    private YelpMetaData yelpMetaData;

    public CreateRestaurantDTO() {
    }

    public YelpMetaData getYelpMetaData() {
        return yelpMetaData;
    }

    public void setYelpMetaData(YelpMetaData yelpMetaData) {
        this.yelpMetaData = yelpMetaData;
    }
}
