package com.cvent.foodflick.models.dto;

import jakarta.validation.constraints.NotNull;

public class VoteDTO {
    private Long vote_id;
    private boolean vote;
    private Long restaurant_id;

    private String created_by;

    public VoteDTO() {
    }

    public VoteDTO(Long vote_id, boolean vote, Long restaurant_id, String created_by) {
        this.vote_id = vote_id;
        this.vote = vote;
        this.restaurant_id = restaurant_id;
        this.created_by = created_by;
    }

    public Long getVote_id() {
        return vote_id;
    }

    public void setVote_id(Long vote_id) {
        this.vote_id = vote_id;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getCreated_by() {
        return created_by;
    }
    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
