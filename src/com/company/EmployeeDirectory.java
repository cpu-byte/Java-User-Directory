package com.company;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {

    private List<Employee> employees;

    public void login(String email, String password) {
        try {
            Employee foundEmployee = null;

            for (Employee employee : employees)
                if (employee.getEmail().equals(email) && employee.getPassword().equals(password))
                    foundEmployee = employee;

            if (foundEmployee != null) foundEmployee.setOnline(true);
            else throw new Exception("Invalid Credentials");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logout(Employee employee) {
        employee.setOnline(false);
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
        return this.employees.size();
    }

    public List<Employee> addEmployee(Employee employee) {
        this.employees.add(employee);
        return employees;
    }

    public List<Employee> removeEmployee(Employee employee) {
        this.employees.remove(employee);
        return employees;
    }


    // standard encapsulation and override methods

    public EmployeeDirectory() {
        this.employees = new ArrayList<>();
    }

    public EmployeeDirectory(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        List<String> stringEmployees = new ArrayList<>();
        for (Employee employee : employees) stringEmployees.add("\n\t" + employee.toString());

        return "EmployeeDirectory{" +
                "employees=" + stringEmployees +
                '}';
    }
}
