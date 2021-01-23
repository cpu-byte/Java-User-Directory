package directory;

import directory.elements.Team;
import directory.elements.user.Employee;

import java.util.List;

public interface DirectoryBaseInterface {

    void addUser(Employee user);
    void removeUser(Employee user);
    void addTeam(Team team);
    void removeTeam(Team team);
    boolean addUserToTeam(Team team, Employee user);
    boolean removeUserFromTeam(Team team, Employee user);
    List<String> employeeTeams(Employee employee);
    List<String> employeesInTeam(Team team);
    List<Employee> searchEmployeesByName(String searchTerm);
    List<Team> searchTeamsByName(String searchTerm);

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
