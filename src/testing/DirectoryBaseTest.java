package testing;

import directory.DirectoryBase;
import directory.TeamDirectory;
import directory.UserDirectory;
import directory.elements.Team;
import directory.elements.TeamInterface;
import directory.elements.user.Employee;
import directory.elements.user.Manager;
import directory.elements.user.UserInterface;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryBaseTest {

    // supporting variables
    final UserInterface emp1 = new Manager("0404419a", "Chandler Bing", "chandler.bing@mail.com", "MyPassword");
    final UserInterface emp2 = new Employee("5ae9e818", "Rachel Green", "rachel.green@mail.com", "SecretPhrase");
    final UserInterface emp3 = new Employee( "a88e2ce4", "Ross Geller", "ross.geller@mail.com", "123456");
    final UserInterface emp4 = new Employee("8bbc2365", "Joey Tribbiani", "joey.tribbinai@mail.com", "seven_forty_one");
    final UserInterface emp5 = new Manager("f94f40ad", "Phoebe Buffay", "phoebe.buffay@mail.com", "newYorkCity");
    final UserInterface emp6 = new Employee("741a1d8d", "Monica Geller", "monica.geller@mail.com", "centralPerk");
    final List<UserInterface> emps = List.of(emp1, emp2, emp3, emp4, emp5, emp6);
    List<UserInterface> empGroup1 = List.of(emp1, emp2, emp3, emp4);
    List<UserInterface> empGroup2 = List.of(emp4, emp5, emp6);
    final TeamInterface team1 = new Team("Finance");
    final TeamInterface team2 = new Team("Admin");
    final List<TeamInterface> teams = List.of(team1, team2);
    // note: emp4 is the only person who is in both teams
    final UserDirectory userDir = new UserDirectory(emps);
    final TeamDirectory teamDir = new TeamDirectory(teams);
    final String dummyName = "hk system";

    final DirectoryBase unnamedDir = new DirectoryBase();
    final DirectoryBase bareDir = new DirectoryBase(dummyName);
    final DirectoryBase dir = new DirectoryBase(dummyName, userDir, teamDir);

    @Test
    void initState() {
        assertEquals(unnamedDir.getName(), "Untitled Directory");
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

        List<UserInterface> newEmps = List.of(emp5, emp6);
        UserDirectory newUserDir = new UserDirectory(newEmps);
        dir.setUserDir(newUserDir);
        assertEquals(dir.getUserDir().getUsers(), newEmps);

        List<TeamInterface> newTeams = List.of(team2);
        TeamDirectory newTeamDir = new TeamDirectory(newTeams);
        dir.setTeamDir(newTeamDir);
        assertEquals(dir.getTeamDir().getTeams(), newTeams);
    }

    @Test
    void teamUserRelationship() {
        bareDir.addUser(emp1);
        bareDir.addUser(emp2);
        bareDir.addTeam(team1);
        bareDir.addTeam(team2);

        // testing: addUserToTeam
        bareDir.addUserToTeam(team2, emp1);
        // emp1's first entry in associated teams should be the id of team2
        assertEquals(bareDir.getUserDir().getUsers().get(0).getAssociatedTeams().get(0), team2.getTeamId());
        assertEquals(bareDir.getUserDir().getUsers().get(0).getAssociatedTeams().size(), 1);
        // team2's first entry in members should be the id of the emp1
        assertEquals(bareDir.getTeamDir().getTeams().get(1).getMembers().get(0), emp1.getEmployeeId());
        assertEquals(bareDir.getTeamDir().getTeams().get(1).getMembers().size(), 1);

        // testing: removeUserFromTeam
        bareDir.removeUserFromTeam(team2, emp1);
        // emp1 shouldn't have any associated teams as they were removed from the only team they were associated
        assertEquals(bareDir.getUserDir().getUsers().get(0).getAssociatedTeams().size(), 0);
        // team2 shouldn't have any members as the it was removed from being associated with any members
        assertEquals(bareDir.getTeamDir().getTeams().get(1).getMembers().size(), 0);
    }

    @Test
    void userRemoval() {
        bareDir.addUser(emp1);
        bareDir.addTeam(team1);

        bareDir.addUserToTeam(team1, emp1);

        // before removal of the user, team members should have a size of 1
        assertEquals(bareDir.getTeamDir().getTeams().get(0).getMembers().size(), 1);
        bareDir.removeUser(emp1);
        // after removal of the user, team members should have a size of 0
        assertEquals(bareDir.getTeamDir().getTeams().get(0).getMembers().size(), 0);
    }

    @Test
    void teamRemoval() {
        bareDir.addUser(emp1);
        bareDir.addTeam(team1);

        bareDir.addUserToTeam(team1, emp1);

        // before removal of the team, user's associated teams should have a size of 1
        assertEquals(bareDir.getUserDir().getUsers().get(0).getAssociatedTeams().size(), 1);
        bareDir.removeTeam(team1);
        // before removal of the team, user's associated teams should have a size of 0
        assertEquals(bareDir.getUserDir().getUsers().get(0).getAssociatedTeams().size(), 0);
    }

    @Test
    void employeeTeams() {
        TeamInterface teamA = new Team("Analytics");
        TeamInterface teamB = new Team("Admin");
        teamA.addMember(emp1.getEmployeeId());
        teamB.addMember(emp1.getEmployeeId());
        dir.setTeamDir(new TeamDirectory(Arrays.asList(teamA, teamB)));

        // emp1 is a part of teamA and teamB
        assertEquals(dir.employeeTeams(emp1).size(), 2);

        // emp2 hasn't been added to any teams yet
        assertEquals(dir.employeeTeams(emp2).size(), 0);
    }

    @Test
    void employeesInTeam() {
        TeamInterface teamA = new Team("Analytics");
        teamA.addMember(emp1.getEmployeeId());
        teamA.addMember(emp2.getEmployeeId());
        TeamInterface teamB = new Team("Admin");
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
    }

    @Test
    void superMethods() {
        assertNotNull(dir.toString());

        var baseDir1 = new DirectoryBase();
        var baseDir2 = new DirectoryBase();
        assertEquals(baseDir1, baseDir2);

        assertEquals(baseDir2.hashCode(), baseDir1.hashCode());
    }

}