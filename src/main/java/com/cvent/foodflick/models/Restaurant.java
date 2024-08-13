package com.cvent.foodflick.models;

import jakarta.persistence.*;

@Entity
public class Restaurant extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private YelpMetaData yelpMetaData;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dinner_party_id")
    private DinnerParty dinnerParty;

    public Restaurant() {
    }

    public Restaurant(Long id, YelpMetaData yelpMetaData, DinnerParty dinnerParty) {
        this.id = id;
        this.yelpMetaData = yelpMetaData;
        this.dinnerParty = dinnerParty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
