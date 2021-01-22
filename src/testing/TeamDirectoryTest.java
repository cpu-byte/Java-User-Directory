package testing;

import directory.TeamDirectory;
import directory.elements.Team;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeamDirectoryTest {

    // supporting variables
    final private Team teamA = new Team("Analytics");
    final private Team teamB = new Team("Marketing");
    final private List<Team> teams = new ArrayList<>(Arrays.asList(teamA, teamB));

    final private TeamDirectory emptyTeamDir = new TeamDirectory();
    final private TeamDirectory teamDir = new TeamDirectory(teams);

    @Test
    void initState() {
        assertEquals(emptyTeamDir.getTeams().size(), 0);
        assertEquals(teamDir.getTeams(), teams);
        assertEquals(teamDir.getTeams().size(), 2);
    }

    @Test
    void setters() {
        // adding teams to the previously empty teams TeamDirectory field
        emptyTeamDir.setTeams(teams);

        // "emptyTeamDir" no longer should be empty
        assertEquals(emptyTeamDir.getTeams().size(), 2);

        assertEquals(emptyTeamDir.getTeams().get(0), teamA);
        assertEquals(emptyTeamDir.getTeams().get(1), teamB);
    }

    @Test
    void numOfTeams() {
        assertEquals(teamDir.getTeams().size(), teamDir.numOfTeams());
        assertEquals(teamDir.getTeams().size(), 2);
    }

    @Test
    void teamsManagement() {
        // adding team
        emptyTeamDir.addTeam(teamA);
        assertEquals(emptyTeamDir.numOfTeams(), 1);
        assertEquals(emptyTeamDir.getTeams().get(0), teamA);

        // adding another team
        emptyTeamDir.addTeam(teamB);
        assertEquals(emptyTeamDir.numOfTeams(), 2);
        assertEquals(emptyTeamDir.getTeams().get(1), teamB);

        // removing team
        emptyTeamDir.removeTeam(teamA);
        assertEquals(emptyTeamDir.numOfTeams(), 1);
        // item at index 0 should now be teamB instead of teamA
        assertEquals(emptyTeamDir.getTeams().get(0), teamB);
    }

}