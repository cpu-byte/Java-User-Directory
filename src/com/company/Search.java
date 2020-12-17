package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Search {

    public static List<Employee> employeesByName(List<Employee> employees, String searchTerm) {
        final String term = searchTerm.toLowerCase();
        var matchingResults = new ArrayList<Employee>();

        // for every employee, lowercase, split the name, and check each against search term
        for (Employee employee : employees)
            for (String name : employee.getName().toLowerCase().split(" "))
                // for every match, add employee to matchingResults list
                if (name.equals(term)) matchingResults.add(employee);

        return matchingResults;
    }

    public static List<Team> teamsByName(List<Team> teams, String searchTerm) {
        final String term = searchTerm.toLowerCase();
        var matchingResults = new ArrayList<Team>();

        // for every team, lowercase, split the name, and check each against search term
        for (Team team : teams)
            for (String teamNameSegment : team.getName().toLowerCase().split(" "))
                // for every match, add team to matchingResults list
                if (teamNameSegment.equals(term)) matchingResults.add(team);

        return matchingResults;
    }

    public static List<Employee> employeesByTeam(List<Employee> employees, List<Team> teams, String searchTerm) {
        final String term = searchTerm.toLowerCase();
        var matchingResults = new ArrayList<Employee>();

        // for every team, lowercase and split the name
        for (Team team : teams)
            for (String teamNameSegment : team.getName().toLowerCase().split(" "))
                if (teamNameSegment.equals(term))
                    // for every match, add employees to matchingResults if they have IDs in the team members list
                    for (Employee employee : employees)
                        if (team.getMembers().contains(employee.getId())) matchingResults.add(employee);

        // returning list w/o duplicated (applicable when employees are in multiple matching teams)
        return matchingResults.stream().distinct().collect(Collectors.toList());
    }

}