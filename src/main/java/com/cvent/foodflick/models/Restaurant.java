package com.cvent.foodflick.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(insertable = false, updatable = false)
    private Long restaurant_id;

    @Embedded
    private YelpMetaData yelpMetaData;

    @ManyToOne
    @JoinColumn(name = "dinner_party_id")
    private DinnerParty dinnerParty;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vote> votes = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(Long id, YelpMetaData yelpMetaData, DinnerParty dinnerParty) {
        this.restaurant_id = id;
        this.yelpMetaData = yelpMetaData;
        this.dinnerParty = dinnerParty;
    }

    public Long getId() {
        return restaurant_id;
    }

    public void setId(Long id) {
        this.restaurant_id = id;
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
