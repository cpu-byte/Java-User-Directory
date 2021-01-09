package com.company;

import java.util.ArrayList;
import java.util.List;

public class UserDirectory {

    private List<Employee> users;

    public Employee login(String email, String password) {
        Employee foundEmployee = null;

        try {

            for (Employee employee : users)
                if (employee.getEmail().equals(email) && employee.getPassword().equals(password))
                    foundEmployee = employee;

            if (foundEmployee != null) foundEmployee.setOnline();
            else throw new Exception("Invalid Credentials");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return foundEmployee;
    }

    public void logout(Employee employee) {
        employee.setOffline();
    }

    public Profile profileById(String employeeId) {
        Profile foundProfile = null;

        for (Employee employee : users)
            if (employee.getEmployeeId().equals(employeeId))
                foundProfile = employee.getProfile();

        return foundProfile;
    }

    public void updateEmployeeBio(Employee author, Employee target, String newBio) {
        try {
            if (author instanceof Manager) target.setProfile(new Profile(newBio));
            else throw new Exception("Invalid Permissions");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int numOfEmployees() {
        return this.users.size();
    }

    public List<Employee> addEmployee(Employee employee) {
        this.users.add(employee);
        return users;
    }

    public List<Employee> removeEmployee(Employee employee) {
        this.users.remove(employee);
        return users;
    }


    // standard encapsulation and override methods

    public UserDirectory() {
        this.users = new ArrayList<>();
    }

    public UserDirectory(List<Employee> employees) {
        this.users = employees;
    }

    public List<Employee> getEmployees() {
        return users;
    }

    public void setEmployees(List<Employee> employees) {
        this.users = employees;
    }

    @Override
    public String toString() {
        List<String> stringEmployees = new ArrayList<>();
        for (Employee employee : users) stringEmployees.add("\n\t" + employee.toString());

        return "EmployeeDirectory{" +
                "users=" + stringEmployees +
                '}';
    }
}
