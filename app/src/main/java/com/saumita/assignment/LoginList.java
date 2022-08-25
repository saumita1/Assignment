package com.saumita.assignment;

import java.io.Serializable;

public class LoginList implements Serializable {
    String id, name, Qualification;

    public LoginList() {
    }

    public LoginList(String id, String name, String Qualification) {
        this.id = id;
        this.name = name;
        this.Qualification = Qualification;
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

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String Qualification) {
        this.Qualification = Qualification;
    }
}
