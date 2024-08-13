package com.cvent.foodflick.models.dto;

import com.cvent.foodflick.models.VotingStrategy;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DinnerPartyDTO {
    @Id
    private long id;

    @NotBlank
    private String dinner_host;
    @NotBlank(message = "Name is mandatory.")
    private String party_name;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Restaurant> restaurants = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Restaurant> winning_restaurants = new ArrayList<>();

    @NotBlank(message = "isFinalized is mandatory")
    private boolean isFinalized;

    @NotBlank(message = "Location is mandatory")
    private String location;

    @NotBlank(message = "Date is mandatory")
    private LocalDate party_date;

    @NotBlank(message = "Time is mandatory")
    private LocalDateTime party_time;

    private VotingStrategy votingStrategy;

    public UpdateDinnerPartyDTO() {
    }

    public String getParty_name() {
        return party_name;
    }

    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Restaurant> getWinning_restaurants() {
        return winning_restaurants;
    }

    public void setWinning_restaurants(List<Restaurant> winning_restaurants) {
        this.winning_restaurants = winning_restaurants;
    }

    public boolean isFinalized() {
        return isFinalized;
    }

    public void setFinalized(boolean finalized) {
        isFinalized = finalized;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getParty_date() {
        return party_date;
    }

    public void setParty_date(LocalDate party_date) {
        this.party_date = party_date;
    }

    public LocalDateTime getParty_time() {
        return party_time;
    }

    public void setParty_time(LocalDateTime party_time) {
        this.party_time = party_time;
    }

    public VotingStrategy getVotingStrategy() {
        return votingStrategy;
    }

    public void setVotingStrategy(VotingStrategy votingStrategy) {
        this.votingStrategy = votingStrategy;
    }
}
