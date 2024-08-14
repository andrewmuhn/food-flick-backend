package com.cvent.foodflick.models.dto;

import jakarta.validation.constraints.NotNull;

public class CreateVoteDTO {
    @NotNull
    private boolean vote;

    private long restaurantId;

    public CreateVoteDTO() {
    }

    public CreateVoteDTO(boolean vote, long restaurantId) {
        this.vote = vote;
        this.restaurantId = restaurantId;
    }

}
