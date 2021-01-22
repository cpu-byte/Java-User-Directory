package directory;

import directory.elements.user.Employee;
import directory.elements.user.Profile;

import java.util.List;

public interface UserDirectoryInterface {

    Employee login(String email, String password);
    void logout(Employee user);
    Profile profileById(String employeeId);
    void updateUserBio(Employee author, Employee target, String newBio);
    int numOfUsers();
    List<Employee> addUser(Employee user);
    List<Employee> removeUser(Employee user);

    // standard encapsulation and override methods
    List<Employee> getUsers();
    void setUsers(List<Employee> users);
    String toString();

}
