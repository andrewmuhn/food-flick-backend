package com.cvent.foodflick.models.dto;

import com.cvent.foodflick.models.VotingStrategy;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CreateDinnerPartyDTO {
    @NotBlank(message = "Name is mandatory.")
    private String party_name;

    @NotBlank(message = "Location is mandatory")
    private String location;

    @NotNull(message = "Date is mandatory")
    private LocalDate party_date;

    @NotNull(message = "Time is mandatory")
    private LocalDateTime party_time;

    private VotingStrategy votingStrategy;

    public CreateDinnerPartyDTO() {
    }

    public CreateDinnerPartyDTO(String party_name, String location, LocalDate party_date, LocalDateTime party_time, VotingStrategy votingStrategy) {
        this.party_name = party_name;
        this.location = location;
        this.party_date = party_date;
        this.party_time = party_time;
        this.votingStrategy = votingStrategy;
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
