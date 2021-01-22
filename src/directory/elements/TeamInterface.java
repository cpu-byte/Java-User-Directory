package directory.elements;

import directory.elements.user.Employee;

import java.util.List;

public interface TeamInterface {

    int numOfMembers();
    List<String> memberIdList();
    List<Employee> addMember(Employee employee);
    List<Employee> removeMember(Employee employee);

    // standard encapsulation and override methods
    String getTeamId();
    void setTeamId(String teamId);
    String getName();
    void setName(String name);
    List<Employee> getMembers();
    void setMembers(List<Employee> members);
    String toString();

}
