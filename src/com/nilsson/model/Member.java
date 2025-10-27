package com.nilsson.model;

import java.util.List;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class Member {
    private int id;
    private String firstName;
    private String lastName;
    private String membershipLevel;
    private List<String> history;

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

    public Member() {

    }

    public Member(int id, String firstName, String lastName, String membershipLevel, List history) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.membershipLevel = membershipLevel;
        this.history = history;
    }

//── Getters & Setters ─────────────────────────────────────────────────────────────────────────────────────────────────

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

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Medlem: " +
                "ID " + id +
                ", " + firstName + " " +
                lastName +
                ", Medlemsnivå: " + membershipLevel;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
