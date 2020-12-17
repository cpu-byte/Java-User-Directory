package com.company;

import java.util.ArrayList;
import java.util.List;

public class HKSystem {

    private String name;
    private EmployeeDirectory employeeDirectory;
    private TeamDirectory teamDirectory;

    public List<Team> employeeTeams(Employee employee) {
        var employeeTeams = new ArrayList<Team>();

        for (Team team : this.teamDirectory.getTeams()) {
            if (team.getMembers().contains(employee.getId()))
                employeeTeams.add(team);
        }

        return employeeTeams;
    }

    public List<Employee> employeesInTeam(Team team) {
        var employeesInTeam = new ArrayList<Employee>();

        for (Employee employee : this.employeeDirectory.getEmployees())
            if (team.getMembers().contains(employee.getId())) employeesInTeam.add(employee);

        return employeesInTeam;
    }


    // standard encapsulation and override methods

    public HKSystem() {
        this.employeeDirectory = new EmployeeDirectory();
        this.teamDirectory = new TeamDirectory();
    }

    public HKSystem(String name) {
        this.name = name;
    }

    public HKSystem(String name, EmployeeDirectory employeeDirectory, TeamDirectory teamDirectory) {
        this.name = name;
        this.employeeDirectory = employeeDirectory;
        this.teamDirectory = teamDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public TeamDirectory getTeamDirectory() {
        return teamDirectory;
    }

    public void setTeamDirectory(TeamDirectory teamDirectory) {
        this.teamDirectory = teamDirectory;
    }

    @Override
    public String toString() {
        return "HKSystem{" +
                "name='" + name + '\'' +
                ",\n employeeDirectory=" + employeeDirectory +
                ",\n teamDirectory=" + teamDirectory +
                '}';
    }
}
