package testing;

import directory.Search;
import directory.elements.Team;
import directory.elements.user.Employee;
import directory.elements.user.Manager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    // supporting variables
    final Manager emp1 = new Manager("0404419a", "Chandler Bing", "chandler.bing@mail.com", "MyPassword");
    final Employee emp2 = new Employee("5ae9e818", "Rachel Green", "rachel.green@mail.com", "SecretPhrase");
    final Employee emp3 = new Employee( "a88e2ce4", "Ross Geller", "ross.geller@mail.com", "123456");
    final Employee emp4 = new Employee("8bbc2365", "Joey Tribbiani", "joey.tribbinai@mail.com", "seven_forty_one");
    final Manager emp5 = new Manager("f94f40ad", "Phoebe Buffay", "phoebe.buffay@mail.com", "newYorkCity");
    final Employee emp6 = new Employee("741a1d8d", "Monica Geller", "monica.geller@mail.com", "centralPerk");
    final List<Employee> emps = List.of(emp1, emp2, emp3, emp4, emp5, emp6);
    final List<Employee> empGroup1 = List.of(emp1, emp2, emp3, emp4);
    List<Employee> empGroup2 = List.of(emp4, emp5, emp6);
    final List<Employee> empGroup3 = List.of(emp1, emp2, emp4, emp5);
    final Team team1 = new Team("Finance");
    final Team team2 = new Team("Admin");
    final List<Team> teams = List.of(team1, team2);
    // note: emp4 is the only person who is in both teams

    @Test
    void employeesByName() {
        // search "Geller" should return two results
        // ... there are two employees with Geller as their surname
        var result1 = Search.employeesByName(emps, "Geller");
        assertEquals(result1.get(0), emp3);
        assertEquals(result1.get(1), emp6);
        assertEquals(result1.size(), 2);

        // searching same term in smaller set of data
        var result2 = Search.employeesByName(empGroup1, "Geller");
        assertEquals(result2.get(0), emp3);
        assertEquals(result2.size(), 1);

        // searching same term in a set of data without any expected matches
        var result3 = Search.employeesByName(empGroup3, "Geller");
        assertEquals(result3.size(), 0);
    }

    @Test
    void teamsByName() {
        // search "Admin" should return a result
        var result1 = Search.teamsByName(teams, "Admin");
        assertEquals(result1.get(0), team2);
        assertEquals(result1.size(), 1);

        // search "Analytics" should return no results
        var result2 = Search.teamsByName(teams, "Analytics");
        assertEquals(result2.size(), 0);
    }
}
