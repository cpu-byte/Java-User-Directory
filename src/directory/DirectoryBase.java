package directory;

import directory.elements.TeamInterface;
import directory.elements.user.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * DirectoryBase holds the team and user directories, holding specialised methods for manipulating directory data
 */
public class DirectoryBase implements DirectoryBaseInterface {

    private String name;
    private UserDirectory userDir;
    private TeamDirectory teamDir;

    /**
     * Add a user to the user directory
     * @param user  user to add into the user directory
     */
    public void addUser(UserInterface user) {
        this.userDir.getUsers().add(user);
    }

    /**
     * Remove a user from the user directory
     * @param user  user to remove from the user directory
     */
    public void removeUser(UserInterface user) {
        // all instances of the user in team's member list will be removed
        for (TeamInterface team : this.teamDir.getTeams())
            if (team.getMembers().contains(user.getEmployeeId())) team.removeMember(user.getEmployeeId());

        this.userDir.getUsers().remove(user);
    }

    /**
     * Team to add to the team directory
     * @param team  team to add into the team directory
     */
    public void addTeam(TeamInterface team) {
        this.teamDir.getTeams().add(team);
    }

    /**
     * Team to remove from the team directory
     * @param team  team to remove from the team directory
     */
    public void removeTeam(TeamInterface team) {
        // all instances of the team in the user's associated teams list will be removed
        for (UserInterface emp : this.userDir.getUsers())
            if (emp.getAssociatedTeams().contains(team.getTeamId())) emp.removeAssociatedTeam(team.getTeamId());

        this.teamDir.getTeams().remove(team);
    }

    /**
     * Add a user to a team (if non-existent, add team to user's associated teams, and add user to team's members)
     * @param team  team subject to having a new member
     * @param user  user subject to having a new associated team
     * @return      true/false value for successful/unsuccessful operation (false: parameter user or team not found)
     */
    public boolean addUserToTeam(TeamInterface team, UserInterface user) {
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

    /**
     * Remove a user from a team (if existent remove team from user's associated teams, remove user from team's members)
     * @param team  team subject to having a member removed
     * @param user  user subject to having a associated team removed
     * @return      true/false value for successful/unsuccessful operation (false: parameter user or team found)
     */
    public boolean removeUserFromTeam(TeamInterface team, UserInterface user) {
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

    /**
     * Return the Team IDs of all the associated teams of the employee
     * @param employee  find their associated teams
     * @return          list of ids of the team
     */
    public List<String> employeeTeams(UserInterface employee) {
        var employeeTeams = new ArrayList<String>();

        // for each team, see if the relevant employee is a member
        for (TeamInterface team : this.teamDir.getTeams())
            if (team.getMembers().contains(employee.getEmployeeId()))
                employeeTeams.add(team.getTeamId());

        return employeeTeams;
    }

    /**
     * Return the Employee ID's of all members of a team
     * @param team  find their members
     * @return      list of id's of the members
     */
    public List<String> employeesInTeam(TeamInterface team) {
        var employeesInTeam = new ArrayList<String>();

        // for each employee, see if the relevant team is associated
        for (UserInterface employee : this.userDir.getUsers())
            if (team.getMembers().contains(employee.getEmployeeId()))
                employeesInTeam.add(employee.getEmployeeId());

        return employeesInTeam;
    }

    /**
     * Search employees by name
     * @param searchTerm    term to search against all employees
     * @return              list of results (no results: empty list)
     */
    public List<UserInterface> searchEmployeesByName(String searchTerm) {
        return Search.employeesByName(this.userDir.getUsers(), searchTerm);
    }

    /**
     * Search teams by name
     * @param searchTerm    term to search against all teams
     * @return              list of teams (no results: empty list)
     */
    public List<TeamInterface> searchTeamsByName(String searchTerm) {
        return Search.teamsByName(this.teamDir.getTeams(), searchTerm);
    }


    // standard encapsulation and override methods

    /**
     * Basic constructor for directory base with new user and team directories
     */
    public DirectoryBase() {
        this.name = "Untitled Directory";
        this.userDir = new UserDirectory();
        this.teamDir = new TeamDirectory();
    }

    /**
     * Constructor for directory base with name and new user and team directories
     * @param name  name of the directory, i.e. "HK System"
     */
    public DirectoryBase(String name) {
        this.name = name;
        this.userDir = new UserDirectory();
        this.teamDir = new TeamDirectory();
    }

    /**
     * Complete constructor for directory base with specification for all fields
     * @param name              name of the directory, i.e. "HK System"
     * @param userDirectory     instance of UserDirectory
     * @param teamDirectory     instance of TeamDirectory
     */
    public DirectoryBase(String name, UserDirectory userDirectory, TeamDirectory teamDirectory) {
        this.name = name;
        this.userDir = userDirectory;
        this.teamDir = teamDirectory;
    }

    /**
     * Getter method for the base directory name
     * @return  current name of the base directory
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the base directory name
     * @param name  new name of the base directory
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the user directory field
     * @return  current user directory
     */
    public UserDirectory getUserDir() {
        return userDir;
    }

    /**
     * Setter method for the user directory field
     * @param userDir   new user directory
     */
    public void setUserDir(UserDirectory userDir) {
        this.userDir = userDir;
    }

    /**
     * Getter method for the team directory field
     * @return  current team directory
     */
    public TeamDirectory getTeamDir() {
        return teamDir;
    }

    /**
     * Setter method for the team directory field
     * @param teamDir   new team directory
     */
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
        return name.equals(that.name) && userDir.equals(that.userDir) && teamDir.equals(that.teamDir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, userDir, teamDir);
    }
}
