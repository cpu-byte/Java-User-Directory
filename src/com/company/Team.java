package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.company.Utility.uuidGenerate;

public class Team {

    private String teamId;
    private String name;
    private List<Employee> members = new ArrayList<>();

    public int numOfMembers() {
        return this.members.size();
    }

    public List<String> memberIdList() {
        var memberIds = new ArrayList<String>();

        for (Employee employee : members)
            memberIds.add(employee.getEmployeeId());

        return memberIds;
    }

    public List<Employee> addMember(Employee employee) {
        this.members.add(employee);
        return members;
    }

    public List<Employee> removeMember(Employee employee) {
        this.members.remove(employee);
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

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getMembers() {
        return members;
    }

    public void setMembers(List<Employee> members) {
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
}
