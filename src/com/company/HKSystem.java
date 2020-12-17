package com.company;

import java.util.ArrayList;
import java.util.List;

public class HKSystem {

    private String name;
    private EmployeeDirectory empDir;
    private TeamDirectory teamDir;

    public List<Team> employeeTeams(Employee employee) {
        var employeeTeams = new ArrayList<Team>();

        for (Team team : this.teamDir.getTeams()) {
            if (team.getMembers().contains(employee.getId()))
                employeeTeams.add(team);
        }

        return employeeTeams;
    }

    public List<Employee> employeesInTeam(Team team) {
        var employeesInTeam = new ArrayList<Employee>();

        for (Employee employee : this.empDir.getEmployees())
            if (team.getMembers().contains(employee.getId())) employeesInTeam.add(employee);

        return employeesInTeam;
    }


    // standard encapsulation and override methods

    public HKSystem() {
        this.empDir = new EmployeeDirectory();
        this.teamDir = new TeamDirectory();
    }

    public HKSystem(String name) {
        this.name = name;
    }

    public HKSystem(String name, EmployeeDirectory employeeDirectory, TeamDirectory teamDirectory) {
        this.name = name;
        this.empDir = employeeDirectory;
        this.teamDir = teamDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return empDir;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.empDir = employeeDirectory;
    }

    public TeamDirectory getTeamDirectory() {
        return teamDir;
    }

    public void setTeamDirectory(TeamDirectory teamDirectory) {
        this.teamDir = teamDirectory;
    }

    @Override
    public String toString() {
        return "HKSystem{" +
                "name='" + name + '\'' +
                ",\n employeeDirectory=" + empDir +
                ",\n teamDirectory=" + teamDir +
                '}';
    }
}
