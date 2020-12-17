package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.company.Utility.uuidGenerate;

public class Team {

    private String id;
    private String name;
    private List<String> members = new ArrayList<>();

    public List<String> addMember(String uuid) {
        this.members.add(uuid);
        return members;
    }

    public List<String> removeMember(String uuid) {
        this.members.remove(uuid);
        return members;
    }


    // standard encapsulation and override methods

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Team(String name) {
        this.id = uuidGenerate();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", members=" + members +
                '}';
    }
}
