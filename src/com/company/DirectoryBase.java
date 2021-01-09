package com.company;

import java.util.ArrayList;
import java.util.List;

public class DirectoryBase {

    private String name;
    private UserDirectory empDir;
    private TeamDirectory teamDir;

    public List<Team> employeeTeams(Employee employee) {
        var employeeTeams = new ArrayList<Team>();

        for (Team team : this.teamDir.getTeams()) {
            if (team.getMembers().contains(employee.getEmployeeId()))
                employeeTeams.add(team);
        }

        return employeeTeams;
    }

    public List<Employee> employeesInTeam(Team team) {
        var employeesInTeam = new ArrayList<Employee>();

        for (Employee employee : this.empDir.getEmployees())
            if (team.getMembers().contains(employee.getEmployeeId())) employeesInTeam.add(employee);

        return employeesInTeam;
    }

    public List<Employee> searchEmployeesByName(String searchTerm) {
        return Search.employeesByName(this.empDir.getEmployees(), searchTerm);
    }

    public List<Team> teamsByName(String searchTerm) {
        return Search.teamsByName(this.teamDir.getTeams(), searchTerm);
    }

    public List<Employee> employeesByTeam(String searchTerm) {
        return Search.employeesByTeam(this.empDir.getEmployees(), this.teamDir.getTeams(), searchTerm);
    }

    // standard encapsulation and override methods

    public DirectoryBase() {
        this.empDir = new UserDirectory();
        this.teamDir = new TeamDirectory();
    }

    public DirectoryBase(String name) {
        this.name = name;
    }

    public DirectoryBase(String name, UserDirectory userDirectory, TeamDirectory teamDirectory) {
        this.name = name;
        this.empDir = userDirectory;
        this.teamDir = teamDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDirectory getEmployeeDirectory() {
        return empDir;
    }

    public void setEmployeeDirectory(UserDirectory userDirectory) {
        this.empDir = userDirectory;
    }

    public TeamDirectory getTeamDirectory() {
        return teamDir;
    }

    public void setTeamDirectory(TeamDirectory teamDirectory) {
        this.teamDir = teamDirectory;
    }

    @Override
    public String toString() {
        return "DirectoryBase{" +
                "name='" + name + '\'' +
                ",\n userDirectory=" + empDir +
                ",\n teamDirectory=" + teamDir +
                '}';
    }
}