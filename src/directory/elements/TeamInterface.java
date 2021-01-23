package directory.elements;

import directory.elements.user.Employee;

import java.util.List;

public interface TeamInterface {

    int numOfMembers();
    List<String> addMember(String employee);
    List<String> removeMember(String employee);

    // standard encapsulation and override methods
    String getTeamId();
    String getName();
    void setName(String name);
    List<String> getMembers();
    void setMembers(List<String> members);
    String toString();
    boolean equals(Object o);
    int hashCode();

}
