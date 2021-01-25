package directory;

import directory.elements.user.ProfileInterface;
import directory.elements.user.UserInterface;

import java.util.List;

public interface UserDirectoryInterface {

    UserInterface login(String email, String password);
    void logout(UserInterface user);
    ProfileInterface profileById(String employeeId);
    boolean updateUserBio(UserInterface author, UserInterface target, String newBio);
    int numOfUsers();

    // standard encapsulation and override methods
    List<UserInterface> getUsers();
    void setUsers(List<UserInterface> users);
    String toString();
    boolean equals(Object o);
    int hashCode();

}
