package directory;

import directory.elements.Team;

import java.util.List;

public interface TeamDirectoryInterface {

    int numOfTeams();

    // standard encapsulation and override methods
    List<Team> getTeams();
    void setTeams(List<Team> teams);
    String toString();
    boolean equals(Object o);
    int hashCode();

}
