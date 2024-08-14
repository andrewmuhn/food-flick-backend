package com.cvent.foodflick.models.dto;

import com.cvent.foodflick.models.YelpMetaData;

public class RestaurantDTO {
    private Long restaurant_id;
    private YelpMetaData yelpMetaData;

    private Long dinner_party_id;

    public RestaurantDTO() {
    }

    public Long getId() {
        return restaurant_id;
    }

    public void setId(Long id) {
        this.restaurant_id = id;
    }

    public YelpMetaData getYelpMetaData() {
        return yelpMetaData;
    }

    public void setYelpMetaData(YelpMetaData yelpMetaData) {
        this.yelpMetaData = yelpMetaData;
    }
}
