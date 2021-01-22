package directory;

import directory.elements.Team;

import java.util.List;

public interface TeamDirectoryInterface {

    int numOfTeams();
    List<Team> addTeam(Team team);
    List<Team> removeTeam(Team team);

    // standard encapsulation and override methods
    List<Team> getTeams();
    void setTeams(List<Team> teams);
    String toString();

}
