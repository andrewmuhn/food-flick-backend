package com.cvent.foodflick.models.dto;

import jakarta.validation.constraints.NotBlank;

public class VoteDTO {
    private long id;

    @NotBlank
    private boolean vote;

    @NotBlank
    private long restaurantId;

    public VoteDTO() {
    }

    public VoteDTO(long id, boolean vote, long restaurantId) {
        this.id = id;
        this.vote = vote;
        this.restaurantId = restaurantId;
    }
}
