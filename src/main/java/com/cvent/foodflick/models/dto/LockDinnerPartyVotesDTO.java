package com.cvent.foodflick.models.dto;

public class LockDinnerPartyVotesDTO {
    private boolean finalized;

    public LockDinnerPartyVotesDTO() {
    }

    public boolean isFinalized() {
        return finalized;
    }

    public void setFinalized(boolean finalized) {
        this.finalized = finalized;
    }
}
