package com.company;

import java.util.Date;

public class Profile {

    private String biography;
    private Date lastUpdated;


    // standard encapsulation and override methods

    public Profile(String biography) {
        this.biography = biography;
        updated();
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
        updated();
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    private void updated() {
        this.lastUpdated = new Date();
    }

    @Override
    public String toString() {
        return "Profile{" +
                "biography='" + biography + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
