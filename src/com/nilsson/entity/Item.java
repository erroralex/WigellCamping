package com.nilsson.entity;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public abstract class Item {

    private double dailyPrice;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public Item() {

    }

    public Item(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public double getTotalPrice(int days) {
        return dailyPrice * days;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
