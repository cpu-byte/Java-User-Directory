package directory;

import directory.elements.Team;
import directory.elements.user.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Flexible abstract search class with employee and team arguments
 */
public abstract class Search {

    /**
     * Search for all employees matching a search term
     * @param employees     list of employees to search through
     * @param searchTerm    search term
     * @return              list of employees (empty if no matches)
     */
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

    /**
     * Search for all teams matching a search term
     * @param teams         list of teams to search through
     * @param searchTerm    search term
     * @return              list of teams (empty if no matches)
     */
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
}
