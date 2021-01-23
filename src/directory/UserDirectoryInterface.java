package directory;

import directory.elements.user.Employee;
import directory.elements.user.Profile;

import java.util.List;

public interface UserDirectoryInterface {

    Employee login(String email, String password);
    void logout(Employee user);
    Profile profileById(String employeeId);
    boolean updateUserBio(Employee author, Employee target, String newBio);
    int numOfUsers();

    // standard encapsulation and override methods
    List<Employee> getUsers();
    void setUsers(List<Employee> users);
    String toString();
    boolean equals(Object o);
    int hashCode();

}
