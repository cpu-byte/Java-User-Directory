package testing;

import directory.elements.Team;
import directory.elements.TeamInterface;
import directory.elements.user.Employee;
import directory.elements.user.UserInterface;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    // supporting variables
    final private String dummyId = "a1b2c3";
    final private String dummyName = "Analytics";
    final private UserInterface emp1 = new Employee("name1", "email1", "password1");
    final private UserInterface emp2 = new Employee("name2", "email2", "password2");
    final private List<UserInterface> employees = new ArrayList<>(Arrays.asList(emp1, emp2));

    final private TeamInterface team = new Team(dummyId, dummyName);
    final private TeamInterface teamIdGen = new Team(dummyName);

    @Test
    void generatedEmployeeId() {
        // on creation of team class, when not inputting a ID, one should be generated
        assertNotNull(teamIdGen.getTeamId());
    }

    @Test
    void initState() {
        assertEquals(team.getTeamId(), dummyId);
        assertEquals(team.getName(), dummyName);
        assertEquals(team.getMembers().size(), 0);
    }

    @Test
    void setters() {
        final var newName = "Human Resources";
        team.setName(newName);
        assertEquals(team.getName(), newName);
    }

    @Test
    void numOfMembers() {
        // after adding some employees as members, check size
        var memberIds = new ArrayList<String>();
        for (UserInterface emp : employees) memberIds.add(emp.getEmployeeId());
        team.setMembers(memberIds);
        assertEquals(team.getMembers().size(), team.numOfMembers());
        assertEquals(team.getMembers().size(), 2);
    }

    @Test
    void memberManagement() {
        // adding team
        team.addMember(emp1.getEmployeeId());
        // ...expecting the adding to affect the size
        assertEquals(team.getMembers().size(), 1);
        // ...expecting the added item to be in the list
        // ...and at index 0
        assertEquals(team.getMembers().get(0), emp1.getEmployeeId());

        team.addMember(emp2.getEmployeeId());
        assertEquals(team.getMembers().size(), 2);
        assertEquals(team.getMembers().get(1), emp2.getEmployeeId());

        // removing team
        team.removeMember(emp1.getEmployeeId());
        // ...expecting th removal to affect the size
        assertEquals(team.getMembers().size(), 1);
        // ...expecting the removed item to not be in the list at index 0
        // ...instead index 0 should be the non-removed item
        assertEquals(team.getMembers().get(0), emp2.getEmployeeId());
    }

    @Test
    void superMethods() {
        assertNotNull(team.toString());

        TeamInterface team1 = new Team("abc", "Analytics");
        TeamInterface team2 = new Team("abc", "Analytics");
        assertEquals(team1, team2);

        assertEquals(team2.hashCode(), team1.hashCode());
    }

}