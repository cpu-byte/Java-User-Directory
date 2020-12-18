package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        /**
         * impl.
         * - remove a user should remove them from all teams
         *
         * test.
         * - when an id is changed in an employee, the ids references in the teams should also be updated
         */

        // employee setup
        var employee1 = new Manager("0404419a", "Chandler Bing", "chandler.bing@mail.com", "MyPassword");
        var employee2 = new Employee("5ae9e818", "Rachel Green", "rachel.green@mail.com", "SecretPhrase");
        var employee3 = new Employee( "a88e2ce4", "Ross Geller", "ross.geller@mail.com", "123456");
        var employee4 = new Employee("8bbc2365", "Joey Tribbiani", "joey.tribbinai@mail.com", "seven_forty_one");
        var employee5 = new Manager("f94f40ad", "Phoebe Buffay", "phoebe.buffay@mail.com", "newYorkCity");
        var employee6 = new Employee("741a1d8d", "Monica Geller", "monica.geller@mail.com", "centralPerk");
        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5, employee6);

        // team setup and member population
        var team1 = new Team("Finance");
        var team2 = new Team("Admin");
        team1.setMembers(List.of(employee1, employee2, employee3, employee4));
        team2.setMembers(List.of(employee4, employee5, employee6));
        List<Team> teams = List.of(team1, team2);

        // hksys setup
        var empDir = new EmployeeDirectory(employees);
        var teamDir = new TeamDirectory(teams);
        var hksys = new HKSystem("Hill and Knowlton", empDir, teamDir);


        System.out.println(hksys);


    }

}
