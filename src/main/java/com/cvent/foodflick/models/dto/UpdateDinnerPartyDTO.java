package com.cvent.foodflick.models.dto;

import com.cvent.foodflick.models.VotingStrategy;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class UpdateDinnerPartyDTO {

    @NotBlank(message = "Name is mandatory.")
    private String party_name;

    @NotBlank(message = "Location is mandatory")
    private String location;

    @NotBlank(message = "Date is mandatory")
    private LocalDateTime party_date;

    private VotingStrategy voting_strategy;

    public UpdateDinnerPartyDTO() {
    }

    public String getParty_name() {
        return party_name;
    }

    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getParty_date() {
        return party_date;
    }

    public void setParty_date(LocalDateTime party_date) {
        this.party_date = party_date;
    }

    public VotingStrategy getVoting_strategy() {
        return voting_strategy;
    }

    public void setVoting_strategy(VotingStrategy voting_strategy) {
        this.voting_strategy = voting_strategy;
    }
}
