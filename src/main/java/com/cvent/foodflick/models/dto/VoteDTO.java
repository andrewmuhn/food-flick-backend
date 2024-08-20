package com.cvent.foodflick.models.dto;

public class VoteDTO {
    private Long vote_id;
    private boolean vote;
    private Long restaurant_id;

    private String createdBy;

    public VoteDTO() {
    }

    public VoteDTO(Long vote_id, boolean vote, Long restaurant_id, String createdBy) {
        this.vote_id = vote_id;
        this.vote = vote;
        this.restaurant_id = restaurant_id;
        this.createdBy = createdBy;
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

    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
