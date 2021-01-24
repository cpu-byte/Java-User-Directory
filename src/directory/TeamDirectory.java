package directory;

import directory.elements.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * A team directory holds information on all teams that are a part of the directory
 */
public class TeamDirectory implements TeamDirectoryInterface {

    private List<Team> teams;

    /**
     * Method to return the number of teams that the team directory is current managing
     * @return  size of the teams directory as an integer value
     */
    public int numOfTeams() {
        return this.teams.size();
    }


    // standard encapsulation and override methods

    /**
     * Constructor for empty TeamDirectory object instance
     */
    public TeamDirectory() {
        this.teams = new ArrayList<>();
    }

    /**
     * Constructor for a populated TeamDirectory object instance
     * @param teams populated list of teams for the TeamDirectory
     */
    public TeamDirectory(List<Team> teams) {
        this.teams = teams;
    }

    /**
     *
     * @return
     */
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
