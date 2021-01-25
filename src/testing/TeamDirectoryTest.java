package testing;

import directory.TeamDirectory;
import directory.TeamDirectoryInterface;
import directory.UserDirectory;
import directory.UserDirectoryInterface;
import directory.elements.Team;
import directory.elements.TeamInterface;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeamDirectoryTest {

    // supporting variables
    final private TeamInterface teamA = new Team("Analytics");
    final private TeamInterface teamB = new Team("Marketing");
    final private List<TeamInterface> teams = new ArrayList<>(Arrays.asList(teamA, teamB));

    final private TeamDirectoryInterface emptyTeamDir = new TeamDirectory();
    final private TeamDirectoryInterface teamDir = new TeamDirectory(teams);

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
    void superMethods() {
        assertNotNull(teamDir.toString());

        UserDirectoryInterface teamDir1 = new UserDirectory();
        UserDirectoryInterface teamDir2 = new UserDirectory();
        assertEquals(teamDir1, teamDir2);

        assertEquals(teamDir2.hashCode(), teamDir1.hashCode());
    }

}