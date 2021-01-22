package directory;

import directory.elements.Team;
import directory.elements.user.Employee;

import java.util.ArrayList;
import java.util.List;

public class DirectoryBase implements DirectoryBaseInterface {

    private String name;
    private UserDirectory userDir;
    private TeamDirectory teamDir;

    public List<Team> employeeTeams(Employee employee) {
        var employeeTeams = new ArrayList<Team>();

        for (Team team : this.teamDir.getTeams()) {
            if (team.getMembers().contains(employee))
                employeeTeams.add(team);
        }

        return employeeTeams;
    }

    public List<Employee> employeesInTeam(Team team) {
        var employeesInTeam = new ArrayList<Employee>();

        for (Employee employee : this.userDir.getUsers())
            if (team.getMembers().contains(employee))
                employeesInTeam.add(employee);

        return employeesInTeam;
    }

    public List<Employee> searchEmployeesByName(String searchTerm) {
        return Search.employeesByName(this.userDir.getUsers(), searchTerm);
    }

    public List<Team> searchTeamsByName(String searchTerm) {
        return Search.teamsByName(this.teamDir.getTeams(), searchTerm);
    }

    public List<Employee> searchEmployeesByTeamName(String searchTerm) {
        return Search.employeesByTeamName(this.userDir.getUsers(), this.teamDir.getTeams(), searchTerm);
    }


    // standard encapsulation and override methods

    public DirectoryBase() {
        this.userDir = new UserDirectory();
        this.teamDir = new TeamDirectory();
    }

    public DirectoryBase(String name) {
        this.name = name;
    }

    public DirectoryBase(String name, UserDirectory userDirectory, TeamDirectory teamDirectory) {
        this.name = name;
        this.userDir = userDirectory;
        this.teamDir = teamDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDirectory getUserDir() {
        return userDir;
    }

    public void setUserDir(UserDirectory userDir) {
        this.userDir = userDir;
    }

    public TeamDirectory getTeamDir() {
        return teamDir;
    }

    public void setTeamDir(TeamDirectory teamDir) {
        this.teamDir = teamDir;
    }

    @Override
    public String toString() {
        return "DirectoryBase{" +
                "name='" + name + '\'' +
                ",\n userDir=" + userDir +
                ",\n teamDir=" + teamDir +
                '}';
    }
}
