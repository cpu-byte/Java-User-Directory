package directory.elements;

import directory.elements.user.Employee;

import java.util.ArrayList;
import java.util.List;

import static directory.elements.Utility.uuidGenerate;

public class Team implements TeamInterface {

    private String teamId;
    private String name;
    private List<String> members = new ArrayList<>();

    public int numOfMembers() {
        return this.members.size();
    }

    public List<String> addMember(String employeeId) {
        this.members.add(employeeId);
        return members;
    }

    public List<String> removeMember(String employeeId) {
        this.members.remove(employeeId);
        return members;
    }


    // standard encapsulation and override methods

    public Team(String id, String name) {
        this.teamId = id;
        this.name = name;
    }

    public Team(String name) {
        this.teamId = uuidGenerate();
        this.name = name;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMembers() {
        return members;
    }

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
