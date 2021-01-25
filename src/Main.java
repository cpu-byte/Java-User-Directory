import directory.DirectoryBase;
import directory.DirectoryBaseInterface;
import directory.elements.Team;
import directory.elements.TeamInterface;
import directory.elements.user.Employee;
import directory.elements.user.Manager;
import directory.elements.user.UserInterface;

public class Main {

    public static void main(String[] args) {

        // creating directory
        DirectoryBaseInterface hksys = new DirectoryBase("Hill and Knowlton");

        // creating teams
        TeamInterface team1 = new Team("Analytics");
        TeamInterface team2 = new Team("Marketing");

        // creating users
        UserInterface user1 = new Manager( "Chandler Bing", "chandler.bing@mail.com", "MyPassword");
        UserInterface user2 = new Employee("Rachel Green", "rachel.green@mail.com", "SecretPhrase");
        UserInterface user3 = new Employee(  "Ross Geller", "ross.geller@mail.com", "123456");
        UserInterface user4 = new Employee( "Joey Tribbiani", "joey.tribbinai@mail.com", "seven_forty_one");
        UserInterface user5 = new Manager( "Phoebe Buffay", "phoebe.buffay@mail.com", "newYorkCity");
        UserInterface user6 = new Employee( "Monica Geller", "monica.geller@mail.com", "centralPerk");

        // adding 2 teams
        hksys.addTeam(team1);
        hksys.addTeam(team2);

        // adding 6 users
        hksys.addUser(user1);
        hksys.addUser(user2);
        hksys.addUser(user3);
        hksys.addUser(user4);
        hksys.addUser(user5);
        hksys.addUser(user6);

        // populating team1
        hksys.addUserToTeam(team1, user1);
        hksys.addUserToTeam(team1, user2);
        hksys.addUserToTeam(team1, user3);
        hksys.addUserToTeam(team1, user4);

        // populating team2
        hksys.addUserToTeam(team2, user4);
        hksys.addUserToTeam(team2, user5);
        hksys.addUserToTeam(team2, user6);

        System.out.println(hksys);

    }

}
