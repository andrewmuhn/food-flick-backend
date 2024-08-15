package com.cvent.foodflick.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DinnerParty extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dinner_party_id;

    @NotBlank(message = "Name is mandatory.")
    private String party_name;

    @OneToMany(mappedBy = "dinnerParty", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Restaurant> restaurants = new ArrayList<>();

    private boolean finalized;

    @NotBlank(message = "Location is mandatory")
    private String location;

    @NotNull(message = "Date is mandatory")
    private LocalDate party_date;

    @NotNull(message = "Time is mandatory")
    private LocalDateTime party_time;


    private VotingStrategy votingStrategy;

    public DinnerParty() {
        this.finalized = false;
    }

    public DinnerParty(Long dinner_party_id, String party_name, List<Restaurant> restaurants, boolean finalized, String location, LocalDate party_date, LocalDateTime party_time, VotingStrategy votingStrategy) {
        this.dinner_party_id = dinner_party_id;
        this.party_name = party_name;
        this.restaurants = restaurants;
        this.finalized = finalized;
        this.location = location;
        this.party_date = party_date;
        this.party_time = party_time;
        this.votingStrategy = votingStrategy;
    }

    public Long getDinner_party_id() {
        return dinner_party_id;
    }

    public void setDinner_party_id(Long id) {
        this.dinner_party_id = id;
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

    public boolean isFinalized() {
        return finalized;
    }

    public void setFinalized(boolean finalized) {
        this.finalized = finalized;
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
