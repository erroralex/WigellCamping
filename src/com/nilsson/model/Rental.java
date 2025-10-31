package com.nilsson.model;

import java.util.*;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class Rental {

    private static final Rental INSTANCE = new Rental();
    private Map<Item, Rental> rentedItems = new HashMap<>();
    private Member member;
    private int days;

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

    private Rental() {

    }

    public Rental(Member member, int days) {
        this.member = member;
        this.days = days;
    }

//── Getters & Setters ─────────────────────────────────────────────────────────────────────────────────────────────────

    public Map<Item, Rental> getRentedItems() {
    return rentedItems;
    }

    public Member getMember() {
        return this.member;
    }

    public int getDays() {
        return this.days;
    }

    public static Rental getInstance() {
        return INSTANCE;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
