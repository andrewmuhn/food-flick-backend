package com.cvent.foodflick.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DinnerParty extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory.")
    private String party_name;

    @OneToMany(mappedBy = "dinnerParty", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Restaurant> restaurants = new ArrayList<>();

    @OneToMany(mappedBy = "dinnerParty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Restaurant> winning_restaurants = new ArrayList<>();

    private boolean isFinalized;

    @NotBlank(message = "Location is mandatory")
    private String location;

    @NotNull(message = "Date is mandatory")
    private LocalDate party_date;

    @NotNull(message = "Time is mandatory")
    private LocalDateTime party_time;


    private VotingStrategy votingStrategy;

    public DinnerParty() {
        this.isFinalized = false;
    }

    public DinnerParty(Long id, String party_name, List<Restaurant> restaurants, List<Restaurant> winning_restaurants, boolean isFinalized, String location, LocalDate party_date, LocalDateTime party_time, VotingStrategy votingStrategy) {
        this.id = id;
        this.party_name = party_name;
        this.restaurants = restaurants;
        this.winning_restaurants = winning_restaurants;
        this.isFinalized = isFinalized;
        this.location = location;
        this.party_date = party_date;
        this.party_time = party_time;
        this.votingStrategy = votingStrategy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
