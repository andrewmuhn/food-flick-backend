package com.cvent.foodflick.models.dto;

import jakarta.validation.constraints.NotBlank;

public class VoteDTO {
    private long id;

    @NotBlank
    private long user_id;

    @NotBlank
    private boolean vote;

    @NotBlank
    private long dinner_party_id;

    @NotBlank
    private long restaurant;

    public VoteDTO() {
    }

    public VoteDTO(long id, long user_id, boolean vote, long dinner_party_id, long restaurant) {
        this.id = id;
        this.user_id = user_id;
        this.vote = vote;
        this.dinner_party_id = dinner_party_id;
        this.restaurant = restaurant;
    }
}
