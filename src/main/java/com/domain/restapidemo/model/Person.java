package com.domain.restapidemo.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private int id;
    @NotBlank
    @Size(min = 2, max = 30)
    private String user;

    @NotBlank
    @Size(min = 2, max = 30)
    private String password;
    private List<Authorities> accesses = new ArrayList<>();

    public Person(){}

    public Person(String name, String pass){
        this.user = name;
        this.password = pass;
    }
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authorities> getAccesses() {
        return accesses;
    }

    public void setAccesses(Authorities access) {
        this.accesses.add(access);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + user + '\'' +
                '}';
    }
}
