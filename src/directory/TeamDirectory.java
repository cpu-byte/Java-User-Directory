package directory;

import directory.elements.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamDirectory implements TeamDirectoryInterface {

    private List<Team> teams;

    public int numOfTeams() {
        return this.teams.size();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamDirectory that = (TeamDirectory) o;

        return teams.equals(that.teams);
    }

    @Override
    public int hashCode() {
        return teams.hashCode();
    }
}
