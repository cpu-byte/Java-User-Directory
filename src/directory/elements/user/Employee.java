package directory.elements.user;

import java.util.*;

import static directory.elements.Utility.uuidGenerate;

/**
 * Employee class is the general class used for employees
 */
public class Employee implements UserInterface {

    private final String employeeId;
    private String name;
    private String email;
    private String password;
    private List<String> associatedTeams = new ArrayList<>();
    private Status status = Status.OFFLINE;
    // statusHistory holds all timestamps and then changed status value
    private List<AbstractMap.SimpleEntry<Date, Status>> statusHistory = new ArrayList<>();
    private Profile profile = new Profile("No info provided.");

    /**
     * Add an associated team ID (string) into the list of associated teams fields
     * @param teamId    the id of the team to be added to the associated teams field
     * @return          updated list of associated teams
     */
    public List<String> addAssociatedTeam(String teamId) {
        this.associatedTeams.add(teamId);
        return associatedTeams;
    }

    /**
     * Remove an associated team ID (string) from the list of associated teams field
     * @param teamId    the id of the team to be removed from the associated teams field
     * @return          updated list of associated teams
     */
    public List<String> removeAssociatedTeam(String teamId) {
        this.associatedTeams.remove(teamId);
        return associatedTeams;
    }

    /**
     * Sets the status of the employee to the enum type of ONLINE
     */
    public void setOnline() {
        this.setStatus(Status.ONLINE);
    }

    /**
     * Sets the status of the employee to the enum type of OFFLINE
     */
    public void setOffline() {
        this.setStatus(Status.OFFLINE);
    }


    // standard encapsulation and override methods

    /**
     * Complete constructor for the Employee class
     * @param employeeId    immutable string identification value for the class
     * @param name          name of the employee
     * @param email         the email of the employee
     * @param password      the employee's password
     */
    public Employee(String employeeId, String name, String email, String password) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Semi-generation constructor for the Employee class
     * @param name      name of the employee
     * @param email     the email of the employee
     * @param password  the employee's password
     */
    public Employee(String name, String email, String password) {
        this.employeeId = uuidGenerate();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Getter method for the ID of the employee
     * @return  identification value for the object
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Getter method for the name of the employee
     * @return  current name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the name of the employee
     * @param name  new name of the employee
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the email of the employee
     * @return  current employee's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for the email of the employee
     * @param email new email of the employee
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method for the password of the employee
     * @return  current employee's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for the password of the employee
     * @param password  new password of the employee
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for the profile of the employee
     * @return  current employee profile value
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * Setter method for the profile of the employee
     * @param profile   new employee profile value
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * Getter method for the status of the employee
     * @return  current employee status value
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Setter method for the status of the employee
     * @param status    new employee status value
     */
    public void setStatus(Status status) {
        // check whether the new status value is not current status value
        if (!status.equals(this.status)) {
            // if different value, the current date and the new value is added to statusHistory field
            this.statusHistory.add(new AbstractMap.SimpleEntry<>(new Date(), status));
            this.status = status;
        }
    }

    /**
     * Getter method for the associated teams of the employee
     * @return  current list of team ids that the user belongs to
     */
    public List<String> getAssociatedTeams() {
        return associatedTeams;
    }

    /**
     * Setter method for the associated teams of the employee
     * @param associatedTeams   new list of team ids that the user belongs to
     */
    public void setAssociatedTeams(List<String> associatedTeams) {
        this.associatedTeams = associatedTeams;
    }

    /**
     * Getter method for the status history of the employee
     * @return  current status history of the employee, list with Date and Status object pair
     */
    public List<AbstractMap.SimpleEntry<Date, Status>> getStatusHistory() {
        return statusHistory;
    }

    /**
     * Setter method for the status history of the employee
     * @param statusHistory  new status history of the employee, list with Date and Status object pair
     */
    public void setStatusHistory(List<AbstractMap.SimpleEntry<Date, Status>> statusHistory) {
        this.statusHistory = statusHistory;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", associatedTeams=" + associatedTeams +
                ", status=" + status +
                ", statusHistory=" + statusHistory +
                ", profile=" + profile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!employeeId.equals(employee.employeeId)) return false;
        if (!name.equals(employee.name)) return false;
        if (!email.equals(employee.email)) return false;
        if (!password.equals(employee.password)) return false;
        if (!associatedTeams.equals(employee.associatedTeams)) return false;
        if (status != employee.status) return false;
        if (!statusHistory.equals(employee.statusHistory)) return false;
        return profile.equals(employee.profile);
    }

    @Override
    public int hashCode() {
        int result = employeeId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + associatedTeams.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + statusHistory.hashCode();
        result = 31 * result + profile.hashCode();
        return result;
    }
}