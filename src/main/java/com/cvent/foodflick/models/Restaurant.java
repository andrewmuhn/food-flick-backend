package com.cvent.foodflick.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurant_id;

    private boolean winner;

    @Embedded
    private YelpMetaData yelpMetaData;

    @ManyToOne
    @JoinColumn(name = "dinner_party_id")
    private DinnerParty dinnerParty;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vote> votes = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(Long restaurant_id, YelpMetaData yelpMetaData, DinnerParty dinnerParty, boolean winner) {
        this.restaurant_id = restaurant_id;
        this.yelpMetaData = yelpMetaData;
        this.dinnerParty = dinnerParty;
        this.winner = winner;
    }

    public Long getId() {
        return restaurant_id;
    }

    public void setId(Long id) {
        this.restaurant_id = id;
    }

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public YelpMetaData getYelpMetaData() {
        return yelpMetaData;
    }

    public void setYelpMetaData(YelpMetaData yelpMetaData) {
        this.yelpMetaData = yelpMetaData;
    }

    public DinnerParty getDinnerParty() {
        return dinnerParty;
    }

    public void setDinnerParty(DinnerParty dinnerParty) {
        this.dinnerParty = dinnerParty;
    }
}
