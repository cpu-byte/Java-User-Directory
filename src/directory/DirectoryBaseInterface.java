package directory;

import directory.elements.TeamInterface;
import directory.elements.user.UserInterface;

import java.util.List;

public interface DirectoryBaseInterface {

    void addUser(UserInterface user);
    void removeUser(UserInterface user);
    void addTeam(TeamInterface team);
    void removeTeam(TeamInterface team);
    boolean addUserToTeam(TeamInterface team, UserInterface user);
    boolean removeUserFromTeam(TeamInterface team, UserInterface user);
    List<String> employeeTeams(UserInterface employee);
    List<String> employeesInTeam(TeamInterface team);
    List<UserInterface> searchEmployeesByName(String searchTerm);
    List<TeamInterface> searchTeamsByName(String searchTerm);

    // standard encapsulation and override methods
    String getName();
    void setName(String name);
    UserDirectory getUserDir();
    void setUserDir(UserDirectory userDirectory);
    TeamDirectory getTeamDir();
    void setTeamDir(TeamDirectory teamDirectory);
    String toString();
    boolean equals(Object o);
    int hashCode();

}
