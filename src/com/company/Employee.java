package com.company;

import java.util.*;

import static com.company.Utility.uuidGenerate;

public class Employee {

    private String employeeId;
    private String name;
    private String email;
    private String password;
    private List<Team> associatedTeams = new ArrayList<>();
    private Status status = Status.OFFLINE;
    private List<AbstractMap.SimpleEntry<Date, Status>> statusHistory = new ArrayList<>();
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
        this.setStatus(Status.ONLINE);
    }

    public void setOffline() {
        this.setStatus(Status.OFFLINE);
    }


    // standard encapsulation and override methods

    public Employee(String employeeId, String name, String email, String password) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Employee(String name, String email, String password) {
        this.employeeId = uuidGenerate();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String id) {
        this.employeeId = id;
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
        if (!status.equals(this.status)) {
            this.statusHistory.add(new AbstractMap.SimpleEntry<>(new Date(), status));
            this.status = status;
        }
    }

    public List<Team> getAssociatedTeams() {
        return associatedTeams;
    }

    public void setAssociatedTeams(List<Team> associatedTeams) {
        this.associatedTeams = associatedTeams;
    }

    public List<AbstractMap.SimpleEntry<Date, Status>> getStatusHistory() {
        return statusHistory;
    }

    public void setStatusHistory(List<AbstractMap.SimpleEntry<Date, Status>> statusHistory) {
        this.statusHistory = statusHistory;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", associatedTeams=" + associatedTeams +
                ", status=" + status +
                ", statusHistory=" + statusHistory +
                ", profile=" + profile +
                '}';
    }
}