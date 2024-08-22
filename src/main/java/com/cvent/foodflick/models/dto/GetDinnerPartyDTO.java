package com.cvent.foodflick.models.dto;

public class GetDinnerPartyDTO {
    private String party_name;
    private Long dinner_party_id;
    private boolean finalized;

    public GetDinnerPartyDTO() {
    }

    public String getParty_name() {
        return party_name;
    }

    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }

    public Long getDinner_party_id() {
        return dinner_party_id;
    }

    public void setDinner_party_id(Long dinner_party_id) {
        this.dinner_party_id = dinner_party_id;
    }

    public boolean isFinalized() {
        return finalized;
    }

    public void setFinalized(boolean finalized) {
        this.finalized = finalized;
    }
}
