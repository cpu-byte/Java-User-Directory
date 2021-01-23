package testing;

import directory.elements.Team;
import directory.elements.user.Employee;
import directory.elements.user.Profile;
import directory.elements.user.Status;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    // supporting variables
    final private String dummyId = "abc123";
    final private String dummyName = "John Doe";
    final private String dummyEmail = "abc@mail.com";
    final private String dummyPassword = "myPassword";
    final private Team team1 = new Team("Analytics");
    final private Team team2 = new Team("Data Science");

    final private Employee emp = new Employee(dummyId, dummyName, dummyEmail, dummyPassword);
    final private Employee empIdGen = new Employee(dummyName, dummyEmail, dummyPassword);

    @Test
    void generatedEmployeeId() {
        // on creation of employee class, when not inputting a ID, one should be generated
        assertNotNull(empIdGen.getEmployeeId());
    }

    @Test
    void initState() {
        // on creation of employee class when inputting an ID, one should not be generated
        assertEquals(emp.getEmployeeId(), dummyId);
        assertEquals(emp.getName(), dummyName);
        assertEquals(emp.getEmail(), dummyEmail);
        assertEquals(emp.getPassword(), dummyPassword);
        assertEquals(emp.getStatus(), Status.OFFLINE);
        assertEquals(emp.getStatusHistory().size(), 0);
        assertEquals(emp.getProfile(), new Profile("No info provided."));
    }

    @Test
    void setters() {
        final var newName = "Josh Doe";
        emp.setName(newName);
        assertEquals(emp.getName(), newName);

        final var newEmail = "xyz@mail.com";
        emp.setEmail(newEmail);
        assertEquals(emp.getEmail(), newEmail);

        final var newPassword = "badPassword";
        emp.setPassword(newPassword);
        assertEquals(emp.getPassword(), newPassword);

        final var newStatus = Status.ONLINE;
        emp.setStatus(newStatus);
        assertEquals(emp.getStatus(), newStatus);
    }

    @Test
    void teamSetter() {
        var teamList = new ArrayList<String>();
        teamList.add(team1.getTeamId());
        emp.setAssociatedTeams(teamList);

        // check no. of teams
        assertEquals(emp.getAssociatedTeams().size(), 1);

        // check type
        assertEquals(emp.getAssociatedTeams().get(0).getClass(), String.class);

        // check correct team name
        assertEquals(emp.getAssociatedTeams().get(0), team1.getTeamId());
    }

    @Test
    void teamManagement() {
        // adding teams
        emp.addAssociatedTeam(team1.getTeamId());
        assertEquals(emp.getAssociatedTeams().size(), 1);
        emp.addAssociatedTeam(team2.getTeamId());
        assertEquals(emp.getAssociatedTeams().size(), 2);

        // removing teams
        emp.removeAssociatedTeam(team2.getTeamId());
        assertEquals(emp.getAssociatedTeams().size(), 1);

        // after removal, check if the non-removed team exists
        assertEquals(emp.getAssociatedTeams().get(0), team1.getTeamId());
    }

    @Test
    void statusHistoryDates() throws InterruptedException {
        // testing the setOnline and setOffline methods as well as Status History

        // get the date before and after setting status online, pt. 1 - online
        final var initDate = new Date();
        TimeUnit.MILLISECONDS.sleep(200);
        emp.setOnline();
        TimeUnit.MILLISECONDS.sleep(200);
        final var afterDate = new Date();

        // checking for correct before and after date, and correct status value
        final var statusEntry0 = emp.getStatusHistory().get(0);
        assertTrue(statusEntry0.getKey().after(initDate));
        assertTrue(statusEntry0.getKey().before(afterDate));
        assertEquals(statusEntry0.getValue(), Status.ONLINE);

        // pt. 2 - offline
        TimeUnit.MILLISECONDS.sleep(200);
        emp.setOffline();
        TimeUnit.MILLISECONDS.sleep(200);
        final var endDate = new Date();

        // checking for correct before and after date, and correct status value
        final var statusEntry1 = emp.getStatusHistory().get(1);
        assertTrue(statusEntry1.getKey().after(afterDate));
        assertTrue(statusEntry1.getKey().before(endDate));
        assertEquals(statusEntry1.getValue(), Status.OFFLINE);
    }

    @Test
    void statusHistorySetter() {

        // checking if status history is not null type when empty
        assertNotNull(emp.getStatusHistory());

        // correct status history list size
        assertEquals(emp.getStatusHistory().size(), 0);
        emp.setOnline();
        assertEquals(emp.getStatusHistory().size(), 1);

        final var nonEmptyHistory = new ArrayList<>(emp.getStatusHistory());
        final var emptyHistory = new ArrayList<AbstractMap.SimpleEntry<Date, Status>>();

        emp.setStatusHistory(emptyHistory);
        assertEquals(emp.getStatusHistory().size(), 0);
        emp.setStatusHistory(nonEmptyHistory);
        assertEquals(emp.getStatusHistory().size(), 1);
    }

}