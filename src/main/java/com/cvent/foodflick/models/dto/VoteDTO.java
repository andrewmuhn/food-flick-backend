package com.cvent.foodflick.models.dto;

import jakarta.validation.constraints.NotNull;

public class VoteDTO {
    private long vote_id;

    @NotNull
    private boolean vote;

    private long restaurant_id;

    public VoteDTO() {
    }

    public VoteDTO(long id, boolean vote, long restaurant_id) {
        this.vote_id = id;
        this.vote = vote;
        this.restaurant_id = restaurant_id;
    }

    public long getVote_id() {
        return vote_id;
    }

    public void setVote_id(long vote_id) {
        this.vote_id = vote_id;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    public long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
