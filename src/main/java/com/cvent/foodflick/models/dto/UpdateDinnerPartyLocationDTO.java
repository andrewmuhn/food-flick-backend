package com.cvent.foodflick.models.dto;

import jakarta.validation.constraints.NotBlank;

public class UpdateDinnerPartyLocationDTO {
    @NotBlank
    private String location;

    public UpdateDinnerPartyLocationDTO() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
