package testing;

import directory.DirectoryBase;
import directory.Search;
import directory.TeamDirectory;
import directory.UserDirectory;
import directory.elements.Team;
import directory.elements.user.Employee;
import directory.elements.user.Manager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryBaseTest {

    // supporting variables
    Manager emp1 = new Manager("0404419a", "Chandler Bing", "chandler.bing@mail.com", "MyPassword");
    Employee emp2 = new Employee("5ae9e818", "Rachel Green", "rachel.green@mail.com", "SecretPhrase");
    Employee emp3 = new Employee( "a88e2ce4", "Ross Geller", "ross.geller@mail.com", "123456");
    Employee emp4 = new Employee("8bbc2365", "Joey Tribbiani", "joey.tribbinai@mail.com", "seven_forty_one");
    Manager emp5 = new Manager("f94f40ad", "Phoebe Buffay", "phoebe.buffay@mail.com", "newYorkCity");
    Employee emp6 = new Employee("741a1d8d", "Monica Geller", "monica.geller@mail.com", "centralPerk");
    List<Employee> emps = List.of(emp1, emp2, emp3, emp4, emp5, emp6);
    List<Employee> empGroup1 = List.of(emp1, emp2, emp3, emp4);
    List<Employee> empGroup2 = List.of(emp4, emp5, emp6);
    Team team1 = new Team("Finance");
    Team team2 = new Team("Admin");
    List<Team> teams = List.of(team1, team2);
    // note: emp4 is the only person who is in both teams
    UserDirectory userDir = new UserDirectory(emps);
    TeamDirectory teamDir = new TeamDirectory(teams);
    String dummyName = "hk system";

    DirectoryBase unnamedDir = new DirectoryBase();
    DirectoryBase bareDir = new DirectoryBase(dummyName);
    DirectoryBase dir = new DirectoryBase(dummyName, userDir, teamDir);

    @Test
    void initState() {
        assertNull(unnamedDir.getName());
        assertEquals(bareDir.getName(), dummyName);
        assertEquals(dir.getName(), dummyName);
        assertEquals(dir.getUserDir(), userDir);
        assertEquals(dir.getTeamDir(), teamDir);
    }

    @Test
    void setters() {
        var newName = "hk system v.2";
        dir.setName(newName);
        assertEquals(dir.getName(), newName);

        List<Employee> newEmps = List.of(emp5, emp6);
        UserDirectory newUserDir = new UserDirectory(newEmps);
        dir.setUserDir(newUserDir);
        assertEquals(dir.getUserDir().getUsers(), newEmps);

        List<Team> newTeams = List.of(team2);
        TeamDirectory newTeamDir = new TeamDirectory(newTeams);
        dir.setTeamDir(newTeamDir);
        assertEquals(dir.getTeamDir().getTeams(), newTeams);
    }

    @Test
    void employeeTeams() {
        Team teamA = new Team("Analytics");
        teamA.addMember(emp1);
        Team teamB = new Team("Admin");
        teamB.addMember(emp1);
        dir.setTeamDir(new TeamDirectory(Arrays.asList(teamA, teamB)));

        // emp1 is a part of teamA and teamB
        assertEquals(dir.employeeTeams(emp1).size(), 2);

        // emp2 hasn't been added to any teams yet
        assertEquals(dir.employeeTeams(emp2).size(), 0);
    }

    @Test
    void employeesInTeam() {
        Team teamA = new Team("Analytics");
        teamA.addMember(emp1);
        teamA.addMember(emp2);
        Team teamB = new Team("Admin");
        dir.setTeamDir(new TeamDirectory(Arrays.asList(teamA, teamB)));

        // teamA has emp1 and emp2
        assertEquals(dir.employeesInTeam(teamA).size(), 2);

        // teamB has no members
        assertEquals(dir.employeesInTeam(teamB).size(), 0);

    }

    @Test
    void searches() {
        // all search methods are heavily tested in SearchTest class

        // search "Geller" should return two results
        // ... there are two employees with Geller as their surname
        var result1 = dir.searchEmployeesByName("Geller");
        assertEquals(result1.get(0), emp3);
        assertEquals(result1.get(1), emp6);
        assertEquals(result1.size(), 2);

        // search "Admin" should return a result
        var result2 = dir.searchTeamsByName("Admin");
        assertEquals(result2.get(0), team2);
        assertEquals(result2.size(), 1);

        // searching "Finance" should return all employees that work in finance
        var result3 = dir.searchEmployeesByTeamName("Finance");
        // number of results should be the number of people in the team
        assertEquals(result3.size(), team1.getMembers().size());
        // result should contains all the same members
        for(Employee emp : team1.getMembers())
            assertTrue(result3.contains(emp));
    }

}