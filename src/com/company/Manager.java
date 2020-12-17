package com.company;

public class Manager extends Employee {

    public Manager(String id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public Manager(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public String toString() {
        return "Manager{} " + super.toString();
    }

}
