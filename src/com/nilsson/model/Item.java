package com.nilsson.model;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public abstract class Item {

    private double dailyPrice;

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

    public Item() {

    }

    public Item(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

//── Getters & Setters ─────────────────────────────────────────────────────────────────────────────────────────────────

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public double getTotalPrice(int days) {
        return dailyPrice * days;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
