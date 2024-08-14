package com.cvent.foodflick.models.dto;

import jakarta.validation.constraints.NotNull;

public class VoteDTO {
    private long vote_id;

    @NotNull
    private boolean vote;

    private long restaurantId;

    public VoteDTO() {
    }

    public VoteDTO(long id, boolean vote, long restaurantId) {
        this.vote_id = id;
        this.vote = vote;
        this.restaurantId = restaurantId;
    }
}
