package directory;

import directory.elements.Team;
import directory.elements.user.Employee;

import java.util.ArrayList;
import java.util.List;

public class DirectoryBase implements DirectoryBaseInterface {

    private String name;
    private UserDirectory userDir;
    private TeamDirectory teamDir;

    public void addUser(Employee user) {
        this.userDir.getUsers().add(user);
    }

    public void removeUser(Employee user) {
        // all instances of the user in team's member list will be removed
        for (Team team : this.teamDir.getTeams())
            if (team.getMembers().contains(user.getEmployeeId())) team.removeMember(user.getEmployeeId());

        this.userDir.getUsers().remove(user);
    }

    public void addTeam(Team team) {
        this.teamDir.getTeams().add(team);
    }

    public void removeTeam(Team team) {
        // all instances of the team in the user's associated teams list will be removed
        for (Employee emp : this.userDir.getUsers())
            if (emp.getAssociatedTeams().contains(team.getTeamId())) emp.removeAssociatedTeam(team.getTeamId());

        this.teamDir.getTeams().remove(team);
    }

    public boolean addUserToTeam(Team team, Employee user) {
        var userIndex = this.userDir.getUsers().indexOf(user);
        var teamIndex = this.teamDir.getTeams().indexOf(team);

        if (userIndex == -1 || teamIndex == -1) return false;

        // if doesn't already exist...
        if (!this.userDir.getUsers().get(userIndex).getAssociatedTeams().contains(team.getTeamId()))
            // add the team id into the user's associated teams
            this.userDir.getUsers().get(userIndex).addAssociatedTeam(team.getTeamId());

        // if doesn't already exist...
        if (!this.teamDir.getTeams().get(teamIndex).getMembers().contains(user.getEmployeeId()))
            // add the member id into the team's members
            this.teamDir.getTeams().get(teamIndex).addMember(user.getEmployeeId());

        return true;
    }

    public boolean removeUserFromTeam(Team team, Employee user) {
        var userIndex = this.userDir.getUsers().indexOf(user);
        var teamIndex = this.teamDir.getTeams().indexOf(team);

        if (userIndex == -1 || teamIndex == -1) return false;

        // if exists
        if (this.userDir.getUsers().get(userIndex).getAssociatedTeams().contains(team.getTeamId()))
            // remove the team id from the user's associated teams
            this.userDir.getUsers().get(userIndex).removeAssociatedTeam(team.getTeamId());

        // if exists
        if (this.teamDir.getTeams().get(teamIndex).getMembers().contains(user.getEmployeeId()))
            // remove the member id from the team's members
            this.teamDir.getTeams().get(teamIndex).removeMember(user.getEmployeeId());

        return true;
    }

    public List<String> employeeTeams(Employee employee) {
        var employeeTeams = new ArrayList<String>();

        for (Team team : this.teamDir.getTeams()) {
            if (team.getMembers().contains(employee.getEmployeeId()))
                employeeTeams.add(team.getTeamId());
        }

        return employeeTeams;
    }

    public List<String> employeesInTeam(Team team) {
        var employeesInTeam = new ArrayList<String>();

        for (Employee employee : this.userDir.getUsers())
            if (team.getMembers().contains(employee.getEmployeeId()))
                employeesInTeam.add(employee.getEmployeeId());

        return employeesInTeam;
    }

    public List<Employee> searchEmployeesByName(String searchTerm) {
        return Search.employeesByName(this.userDir.getUsers(), searchTerm);
    }

    public List<Team> searchTeamsByName(String searchTerm) {
        return Search.teamsByName(this.teamDir.getTeams(), searchTerm);
    }


    // standard encapsulation and override methods

    public DirectoryBase() {
        this.userDir = new UserDirectory();
        this.teamDir = new TeamDirectory();
    }

    public DirectoryBase(String name) {
        this.name = name;
        this.userDir = new UserDirectory();
        this.teamDir = new TeamDirectory();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectoryBase that = (DirectoryBase) o;

        if (!name.equals(that.name)) return false;
        if (!userDir.equals(that.userDir)) return false;
        return teamDir.equals(that.teamDir);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + userDir.hashCode();
        result = 31 * result + teamDir.hashCode();
        return result;
    }
}
