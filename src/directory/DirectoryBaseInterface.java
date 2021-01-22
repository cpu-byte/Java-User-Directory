package directory;

import directory.elements.Team;
import directory.elements.user.Employee;

import java.util.List;

public interface DirectoryBaseInterface {

    List<Team> employeeTeams(Employee employee);
    List<Employee> employeesInTeam(Team team);
    List<Employee> searchEmployeesByName(String searchTerm);
    List<Team> searchTeamsByName(String searchTerm);
    List<Employee> searchEmployeesByTeam(String searchTerm);

    // standard encapsulation and override methods
    String getName();
    void setName(String name);
    UserDirectory getUserDir();
    void setUserDir(UserDirectory userDirectory);
    TeamDirectory getTeamDir();
    void setTeamDir(TeamDirectory teamDirectory);
    String toString();

}
