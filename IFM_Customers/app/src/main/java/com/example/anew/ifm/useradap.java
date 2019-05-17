package com.example.anew.ifm;

/**
 * Created by new on 12-01-2018.
 */

public class useradap {
    int id;
    String refral;
    String firstname;
    String lastname;

    public useradap(int id, String refral, String firstname, String lastname) {
        this.id = id;
        this.refral = refral;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefral() {
        return refral;
    }

    public void setRefral(String refral) {
        this.refral = refral;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
