package testing;

import directory.elements.Team;
import directory.elements.user.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    // supporting variables
    final private String dummyId = "a1b2c3";
    final private String dummyName = "Analytics";
    final private Employee emp1 = new Employee("name1", "email1", "password1");
    final private Employee emp2 = new Employee("name2", "email2", "password2");
    final private List<Employee> employees = new ArrayList<>(Arrays.asList(emp1, emp2));

    final private Team team = new Team(dummyId, dummyName);
    final private Team teamIdGen = new Team(dummyName);

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
        final var newId = "123abc";
        team.setTeamId(newId);
        assertEquals(team.getTeamId(), newId);

        final var newName = "Human Resources";
        team.setName(newName);
        assertEquals(team.getName(), newName);
    }

    @Test
    void numOfMembers() {
        // after adding some employees as members, check size
        team.setMembers(employees);
        assertEquals(team.getMembers().size(), team.numOfMembers());
        assertEquals(team.getMembers().size(), 2);
    }

    @Test
    void memberIdList() {
        // after adding some employees as members, check contents
        team.setMembers(employees);

        // all items in the employees list have to be apart of the team's members
        var empIdList = new ArrayList<String>();
        for(Employee emp : employees) {
            empIdList.add(emp.getEmployeeId());
            assertTrue(team.memberIdList().contains(emp.getEmployeeId()));
        }
        // so all ids in the value returned by memberIdList should
        // ...contain all employees variable employee ids
        for(String empId : empIdList)
            assertTrue(team.memberIdList().contains(empId));
    }

    @Test
    void memberManagement() {
        // adding team
        team.addMember(emp1);
        // ...expecting the adding to affect the size
        assertEquals(team.getMembers().size(), 1);
        // ...expecting the added item to be in the list
        // ...and at index 0
        assertEquals(team.getMembers().get(0), emp1);

        team.addMember(emp2);
        assertEquals(team.getMembers().size(), 2);
        assertEquals(team.getMembers().get(1), emp2);

        // removing team
        team.removeMember(emp1);
        // ...expecting th removal to affect the size
        assertEquals(team.getMembers().size(), 1);
        // ...expecting the removed item to not be in the list at index 0
        // ...instead index 0 should be the non-removed item
        assertEquals(team.getMembers().get(0), emp2);
    }

}