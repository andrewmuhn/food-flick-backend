package com.cvent.foodflick.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Vote extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vote_id;

    @NotNull
    private boolean vote;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Vote() {
    }

    public Vote(Long vote_id, boolean vote, Restaurant restaurant) {
        this.vote_id = vote_id;
        this.vote = vote;
        this.restaurant = restaurant;
    }

    public Long getVote_id() {
        return vote_id;
    }

    public void setVote_id(Long vote_id) {
        this.vote_id = vote_id;
    }

    @NotNull
    public boolean isVote() {
        return vote;
    }

    public void setVote(@NotNull boolean vote) {
        this.vote = vote;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
