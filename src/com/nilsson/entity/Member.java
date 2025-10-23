package com.nilsson.entity;

import java.util.List;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class Member {
    private int id;
    private String firstName;
    private String lastName;
    private String membershipLevel;
    private List<String> history;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public Member() {

    }

    public Member(int id, String firstName, String lastName, String membershipLevel, List history) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.membershipLevel = membershipLevel;
        this.history = history;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
