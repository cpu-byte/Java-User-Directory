package testing;

import directory.TeamDirectory;
import directory.TeamDirectoryInterface;
import directory.UserDirectory;
import directory.UserDirectoryInterface;
import directory.elements.user.Employee;
import directory.elements.user.Manager;
import directory.elements.user.Status;
import directory.elements.user.UserInterface;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDirectoryTest {

    final private UserInterface empA = new Employee("nameA", "emailA", "passwordA");
    final private UserInterface empB = new Employee("nameB", "emailB", "passwordB");
    final private UserInterface mgr = new Manager("nameM", "emailM", "passwordM");
    final private List<UserInterface> emps = new ArrayList<>(Arrays.asList(empA, empB));

    final private UserDirectoryInterface emptyUserDir = new UserDirectory();
    final private UserDirectoryInterface userDir = new UserDirectory(emps);

    @Test
    void initState() {
        assertEquals(emptyUserDir.getUsers().size(), 0);
        assertEquals(userDir.getUsers().size(), 2);
        assertEquals(userDir.getUsers(), emps);
    }

    @Test
    void setters() {
        emptyUserDir.setUsers(emps);
        assertEquals(emptyUserDir.getUsers().size(), 2);
    }

    @Test
    void loginLogout() {
        // before logging in, teamA is at index 0 should be offline
        assertEquals(userDir.getUsers().get(0).getStatus(), Status.OFFLINE);

        // after logging in, the same user should now be online
        var loggedInEmp = userDir.login("emailA", "passwordA");
        assertEquals(userDir.getUsers().get(0).getStatus(), Status.ONLINE);

        // after logging out, the user should be back in offline
        userDir.logout(loggedInEmp);
        assertEquals(userDir.getUsers().get(0).getStatus(), Status.OFFLINE);
    }

    @Test
    void profileById() {
        var empAId = empA.getEmployeeId();
        assertEquals(userDir.profileById(empAId).getBiography(), "No info provided.");
    }

    @Test
    void updateUserBio() {
        // confirming default initial profile biography is set
        assertEquals(empA.getProfile().getBiography(), "No info provided.");

        // changing bio when author is a manager type
        final var newBio = "Designer";
        final var validityResult =
                userDir.updateUserBio(mgr, empA, newBio);
        assertEquals(empA.getProfile().getBiography(), newBio);
        assertTrue(validityResult);

        // changing bio when author is a employee type
        assertFalse(userDir.updateUserBio(empB, empA, newBio + " 2"));
        // return is false for when the permissions are invalid, i.e.
        // when an employee (not manager) is modifying the biography of something else

        // biography is unchanged, having no " 2" at the end
        assertEquals(empA.getProfile().getBiography(), newBio);
    }

    @Test
    void numOfUsers() {
        assertEquals(emptyUserDir.getUsers().size(), 0);
        assertEquals(emptyUserDir.numOfUsers(), 0);

        emptyUserDir.setUsers(emps);

        // no longer an "empty" user directory
        assertEquals(emptyUserDir.getUsers().size(), 2);
        assertEquals(emptyUserDir.numOfUsers(), 2);
    }

    @Test
    void superMethods() {
        assertNotNull(userDir.toString());

        TeamDirectoryInterface userDir1 = new TeamDirectory();
        TeamDirectoryInterface userDir2 = new TeamDirectory();
        assertEquals(userDir1, userDir2);

        assertEquals(userDir2.hashCode(), userDir1.hashCode());
    }

}