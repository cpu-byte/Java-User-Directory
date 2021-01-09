package com.company;

public class Manager extends Employee {

    public Manager(String managerId, String name, String email, String password) {
        super(managerId, name, email, password);
    }

    public Manager(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public String toString() {
        return "Manager{} " + super.toString();
    }

}
