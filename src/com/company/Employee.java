package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.company.Utility.uuidGenerate;

public class Employee {

    private String id;
    private String name;
    private String email;
    private String password;
    private List<Team> associatedTeams = new ArrayList<>();
    private Status status = Status.OFFLINE;
    private Date lastOnline = new Date();
    private Profile profile = new Profile("No info provided.");

    public List<Team> addAssociatedTeam(Team team) {
        this.associatedTeams.add(team);
        return associatedTeams;
    }

    public List<Team> removeAssociatedTeam(Team team) {
        this.associatedTeams.remove(team);
        return associatedTeams;
    }

    public void setOnline() {
        this.status = Status.ONLINE;
    }

    public void setOffline() {
        this.status = Status.OFFLINE;
    }


    // standard encapsulation and override methods

    public Employee(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Employee(String name, String email, String password) {
        this.id = uuidGenerate();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        this.lastOnline = new Date();
    }

    public List<Team> getAssociatedTeams() {
        return associatedTeams;
    }

    public void setAssociatedTeams(List<Team> associatedTeams) {
        this.associatedTeams = associatedTeams;
    }

    public Date getLastOnline() {
        return lastOnline;
    }

    public void setLastOnline(Date lastOnline) {
        this.lastOnline = lastOnline;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", associatedTeams=" + associatedTeams +
                ", status=" + status +
                ", lastOnline=" + lastOnline +
                ", profile=" + profile +
                '}';
    }
}