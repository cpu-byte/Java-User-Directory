package directory;

import directory.elements.user.Employee;
import directory.elements.user.Manager;
import directory.elements.user.Profile;

import java.util.ArrayList;
import java.util.List;

public class UserDirectory implements UserDirectoryInterface {

    private List<Employee> users;

    public Employee login(String email, String password) {
        Employee userFound = null;

        try {

            for (Employee user : users)
                if (user.getEmail().equals(email) && user.getPassword().equals(password))
                    userFound = user;

            if (userFound != null) userFound.setOnline();
            else throw new Exception("Invalid Credentials");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userFound;
    }

    public void logout(Employee user) {
        user.setOffline();
    }

    public Profile profileById(String employeeId) {
        Profile foundProfile = null;

        for (Employee employee : users)
            if (employee.getEmployeeId().equals(employeeId))
                foundProfile = employee.getProfile();

        return foundProfile;
    }

    public boolean updateUserBio(Employee author, Employee target, String newBio) {
        if (author instanceof Manager) target.setProfile(new Profile(newBio));
        else return false;
        return true;
    }

    public int numOfUsers() {
        return this.users.size();
    }

    public List<Employee> addUser(Employee user) {
        this.users.add(user);
        return users;
    }

    public List<Employee> removeUser(Employee user) {
        this.users.remove(user);
        return users;
    }


    // standard encapsulation and override methods

    public UserDirectory() {
        this.users = new ArrayList<>();
    }

    public UserDirectory(List<Employee> users) {
        this.users = users;
    }

    public List<Employee> getUsers() {
        return users;
    }

    public void setUsers(List<Employee> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        List<String> stringUsers = new ArrayList<>();
        for (Employee employee : users) stringUsers.add("\n\t" + employee.toString());

        return "EmployeeDirectory{" +
                "users=" + stringUsers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDirectory that = (UserDirectory) o;

        return users.equals(that.users);
    }

    @Override
    public int hashCode() {
        return users.hashCode();
    }
}
