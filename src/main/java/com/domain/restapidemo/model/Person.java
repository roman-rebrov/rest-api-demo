package com.domain.restapidemo.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Person {

    @NotBlank
    @Size(min = 3, max = 20)
    private String user;

    @NotBlank
    @Size(min = 3, max = 20)
    private String password;
    private List<Authorities> accesses;

    public Person(String user, String pass, List<Authorities> accesses){
        this.user = user;
        this.password = pass;
        this.accesses = accesses;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAccesses() {
        return accesses;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", name='" + user + '\'' +
                '}';
    }
}
