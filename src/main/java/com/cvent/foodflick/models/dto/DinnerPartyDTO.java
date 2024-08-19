package com.cvent.foodflick.models.dto;

import com.cvent.foodflick.models.VotingStrategy;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DinnerPartyDTO {
    private Long dinner_party_id;
    @NotBlank(message = "Name is mandatory.")
    private String party_name;
    private List<RestaurantDTO> restaurants = new ArrayList<RestaurantDTO>();
    private boolean finalized;
    @NotBlank(message = "Location is mandatory")
    private String location;
    private @NotNull(message = "Date is mandatory") LocalDateTime party_date;
    private VotingStrategy voting_strategy;

    public DinnerPartyDTO() {
    }

    public Long getDinner_party_id() {
        return dinner_party_id;
    }

    public void setDinner_party_id(Long dinner_party_id) {
        this.dinner_party_id = dinner_party_id;
    }

    public String getParty_name() {
        return party_name;
    }

    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }

    public List<RestaurantDTO> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantDTO> restaurants) {
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

    public @NotNull(message = "Date is mandatory") LocalDateTime getParty_date() {
        return party_date;
    }

    public void setParty_date(@NotNull(message = "Date is mandatory") LocalDateTime party_date) {
        this.party_date = party_date;
    }

    public VotingStrategy getVoting_strategy() {
        return voting_strategy;
    }

    public void setVoting_strategy(VotingStrategy voting_strategy) {
        this.voting_strategy = voting_strategy;
    }
}
