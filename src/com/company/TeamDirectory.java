package com.company;

import java.util.ArrayList;
import java.util.List;

public class TeamDirectory {

    private List<Team> teams;

    public int numOfTeams() {
        return this.teams.size();
    }

    public List<Team> addTeam(Team team) {
        this.teams.add(team);
        return teams;
    }

    public List<Team> removeTeam(Team team) {
        this.teams.remove(team);
        return teams;
    }

    // standard encapsulation and override methods

    public TeamDirectory() {
        this.teams = new ArrayList<>();
    }

    public TeamDirectory(List<Team> teams) {
        this.teams = teams;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        List<String> stringTeams = new ArrayList<>();
        for (Team team : this.teams) stringTeams.add("\n\t" + team.toString());

        return "TeamDirectory{" +
                "teams=" + stringTeams +
                '}';
    }
}
