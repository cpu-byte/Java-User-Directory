package directory;

import directory.elements.TeamInterface;

import java.util.List;

public interface TeamDirectoryInterface {

    int numOfTeams();

    // standard encapsulation and override methods
    List<TeamInterface> getTeams();
    void setTeams(List<TeamInterface> teams);
    String toString();
    boolean equals(Object o);
    int hashCode();

}
