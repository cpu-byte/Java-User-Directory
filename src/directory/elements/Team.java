package directory.elements;

import java.util.ArrayList;
import java.util.List;

import static directory.elements.Utility.uuidGenerate;

/**
 * Team class holds information on a singular team
 */
public class Team implements TeamInterface {

    private final String teamId;
    private String name;
    private List<String> members = new ArrayList<>();

    /**
     * Calculate how many members a team as
     * @return  number of employees in the team
     */
    public int numOfMembers() {
        return this.members.size();
    }

    /**
     * Add a member to the team
     * @param employeeId    string id of a employee/manager class to add
     * @return              updated list of members in the team
     */
    public List<String> addMember(String employeeId) {
        this.members.add(employeeId);
        return members;
    }

    /**
     * Remove a member from the team
     * @param employeeId    string id of the employee/manager class to remove
     * @return              updated list of members in the team
     */
    public List<String> removeMember(String employeeId) {
        this.members.remove(employeeId);
        return members;
    }


    // standard encapsulation and override methods

    /**
     * Complete constructor for the Team class
     * @param id    id of the team
     * @param name  team of the team
     */
    public Team(String id, String name) {
        this.teamId = id;
        this.name = name;
    }

    /**
     * Semi-generated (id) constructor for the team class
     * @param name  name of the team
     */
    public Team(String name) {
        this.teamId = uuidGenerate();
        this.name = name;
    }

    /**
     * Getter method for the team ID
     * @return  current value of the team id
     */
    public String getTeamId() {
        return teamId;
    }

    /**
     * Getter method for the team name
     * @return  current value of the team name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the team name
     * @param name  new value of the team name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the team's members
     * @return  current list of team members
     */
    public List<String> getMembers() {
        return members;
    }

    /**
     * Setter method for the team's members
     * @param members   new list of teams member
     */
    public void setMembers(List<String> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId='" + teamId + '\'' +
                ", name='" + name + '\'' +
                ", members=" + members +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (!teamId.equals(team.teamId)) return false;
        if (!name.equals(team.name)) return false;
        return members.equals(team.members);
    }

    @Override
    public int hashCode() {
        int result = teamId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + members.hashCode();
        return result;
    }
}
