package directory.elements.user;

import directory.elements.Team;

import java.util.AbstractMap;
import java.util.Date;
import java.util.List;

public interface UserInterface {

    List<Team> addAssociatedTeam(Team team);
    List<Team> removeAssociatedTeam(Team team);
    void setOnline();
    void setOffline();

    // standard encapsulation and override methods
    String getEmployeeId();
    void setEmployeeId(String id);
    String getName();
    void setName(String name);
    String getEmail();
    void setEmail(String email);
    String getPassword();
    void setPassword(String password);
    Profile getProfile();
    void setProfile(Profile profile);
    Status getStatus();
    void setStatus(Status status);
    List<Team> getAssociatedTeams();
    void setAssociatedTeams(List<Team> associatedTeams);
    List<AbstractMap.SimpleEntry<Date, Status>> getStatusHistory();
    void setStatusHistory(List<AbstractMap.SimpleEntry<Date, Status>> statusHistory);
    String toString();

}
