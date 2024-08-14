package com.cvent.foodflick.models.dto;

import com.cvent.foodflick.models.YelpMetaData;

public class RestaurantDTO {
    private Long id;
    private YelpMetaData yelpMetaData;

    private Long dinner_party_id;

    public RestaurantDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public YelpMetaData getYelpMetaData() {
        return yelpMetaData;
    }

    public void setYelpMetaData(YelpMetaData yelpMetaData) {
        this.yelpMetaData = yelpMetaData;
    }
}
