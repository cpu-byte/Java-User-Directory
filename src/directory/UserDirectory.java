package directory;

import directory.elements.user.Employee;
import directory.elements.user.Manager;
import directory.elements.user.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * A user directory holds information on all users that are a part of the directory
 */
public class UserDirectory implements UserDirectoryInterface {

    private List<Employee> users;

    /**
     * Method to login a user when provided the email and password
     * @param email     email of an existing user that belong in the user directory
     * @param password  password of an existing user that belongs in the user directory
     * @return          upon login: the employee/manager object, invalid credentials will return null value
     */
    public Employee login(String email, String password) {
        Employee userFound = null;

        // search for a user with those specific details
        for (Employee user : users)
            if (user.getEmail().equals(email) && user.getPassword().equals(password))
                userFound = user;

        // if user found, make then online
        if (userFound != null) userFound.setOnline();

        return userFound;
    }

    /**
     * Method to logout a user given the user object
     * @param user  object of the user (employee/manager) that should be logged out
     */
    public void logout(Employee user) {
        user.setOffline();
    }

    /**
     * Method to get the profile of a user given the user ID
     * @param employeeId    id of the employee/manager that you wish to get the profile of
     * @return              if found existing ID: the profile of the user, non-found: return null
     */
    public Profile profileById(String employeeId) {
        Profile foundProfile = null;

        // compare all user's id with the given id in the parameter
        for (Employee employee : users)
            if (employee.getEmployeeId().equals(employeeId))
                foundProfile = employee.getProfile();

        return foundProfile;
    }

    /**
     * Update the Profile biography of a user as a manager
     * @param author    authorised author, required to be a instance of manager
     * @param target    the user who will have the new biography
     * @param newBio    new biography that will be applied to the Profile of the user
     * @return          true: successfully updated, false: invalid permission (author not authorised)
     */
    public boolean updateUserBio(Employee author, Employee target, String newBio) {
        if (author instanceof Manager) target.setProfile(new Profile(newBio));
        else return false;
        return true;
    }

    /**
     * Get the number of users contains in the user directory
     * @return  value of users in the user directory
     */
    public int numOfUsers() {
        return this.users.size();
    }


    // standard encapsulation and override methods

    /**
     * Constructor for empty UserDirectory object instance
     */
    public UserDirectory() {
        this.users = new ArrayList<>();
    }

    /**
     * Constructor for a populated UserDirectory object instance
     * @param users populated list of users for the UserDirectory
     */
    public UserDirectory(List<Employee> users) {
        this.users = users;
    }

    /**
     * Getter method for the UserDirectory's users field
     * @return  current list of users
     */
    public List<Employee> getUsers() {
        return users;
    }

    /**
     * Setter method for the UserDirectory's users field
     * @param users new list of users
     */
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
