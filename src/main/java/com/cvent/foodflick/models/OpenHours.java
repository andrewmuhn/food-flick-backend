package com.cvent.foodflick.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OpenHours {
    private boolean is_overnight;
    @Column(name = "\"start\"")
    private int start;
    @Column(name = "\"end\"")
    private int end;
    @Column(name = "\"day\"")
    private int day;

    public OpenHours() {
    }

    public boolean isIs_overnight() {
        return is_overnight;
    }

    public void setIs_overnight(boolean is_overnight) {
        this.is_overnight = is_overnight;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}