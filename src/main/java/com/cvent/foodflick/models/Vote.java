package com.cvent.foodflick.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Vote extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    private long id;

    @NotBlank
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private long user_id;

    @NotBlank
    private boolean vote;

    @NotBlank
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dinner_parties", referencedColumnName = "id")
    private long dinner_party_id;

    @NotBlank
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurants", referencedColumnName = "id")
    private long restaurant;

    public Vote() {
    }

    public Vote(long id, long user_id, boolean vote, long dinner_party_id, long restaurant) {
        this.id = id;
        this.user_id = user_id;
        this.vote = vote;
        this.dinner_party_id = dinner_party_id;
        this.restaurant = restaurant;
    }
}
