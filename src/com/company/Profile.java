package com.company;

import java.util.Date;

public class Profile {

    private String biography;
    private Date lastUpdated;

    private void updated() {
        this.lastUpdated = new Date();
    }


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

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "biography='" + biography + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
