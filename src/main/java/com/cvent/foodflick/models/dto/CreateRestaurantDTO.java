package com.cvent.foodflick.models.dto;

import com.cvent.foodflick.models.YelpMetaData;

public class CreateRestaurantDTO {

    private YelpMetaData yelpMetaData;

    private Long dinner_party_id;

    public CreateRestaurantDTO() {
    }

    public YelpMetaData getYelpMetaData() {
        return yelpMetaData;
    }

    public void setYelpMetaData(YelpMetaData yelpMetaData) {
        this.yelpMetaData = yelpMetaData;
    }

    public Long getDinner_party_id() {
        return dinner_party_id;
    }

    public void setDinner_party_id(Long dinner_party_id) {
        this.dinner_party_id = dinner_party_id;
    }
}
