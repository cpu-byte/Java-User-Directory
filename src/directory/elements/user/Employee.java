package directory.elements.user;

import directory.elements.Team;

import java.util.*;

import static directory.elements.Utility.uuidGenerate;

public class Employee implements UserInterface {

    private String employeeId;
    private String name;
    private String email;
    private String password;
    private List<String> associatedTeams = new ArrayList<>();
    private Status status = Status.OFFLINE;
    private List<AbstractMap.SimpleEntry<Date, Status>> statusHistory = new ArrayList<>();
    private Profile profile = new Profile("No info provided.");

    public List<String> addAssociatedTeam(String teamId) {
        this.associatedTeams.add(teamId);
        return associatedTeams;
    }

    public List<String> removeAssociatedTeam(String teamId) {
        this.associatedTeams.remove(teamId);
        return associatedTeams;
    }

    public void setOnline() {
        this.setStatus(Status.ONLINE);
    }

    public void setOffline() {
        this.setStatus(Status.OFFLINE);
    }


    // standard encapsulation and override methods

    public Employee(String employeeId, String name, String email, String password) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Employee(String name, String email, String password) {
        this.employeeId = uuidGenerate();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (!status.equals(this.status)) {
            this.statusHistory.add(new AbstractMap.SimpleEntry<>(new Date(), status));
            this.status = status;
        }
    }

    public List<String> getAssociatedTeams() {
        return associatedTeams;
    }

    public void setAssociatedTeams(List<String> associatedTeams) {
        this.associatedTeams = associatedTeams;
    }

    public List<AbstractMap.SimpleEntry<Date, Status>> getStatusHistory() {
        return statusHistory;
    }

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