package com.cvent.foodflick.models;

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

@Entity
public class Vote extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    private long id;

    @NotBlank
    private boolean vote;

    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Vote() {
    }

    @NotBlank
    public long getId() {
        return id;
    }

    public void setId(@NotBlank long id) {
        this.id = id;
    }

    @NotBlank
    public boolean isVote() {
        return vote;
    }

    public void setVote(@NotBlank boolean vote) {
        this.vote = vote;
    }

    @NotBlank
    public long getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(@NotBlank long restaurant) {
        this.restaurant = restaurant;
    }
}
