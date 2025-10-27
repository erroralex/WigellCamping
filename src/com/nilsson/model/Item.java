package com.nilsson.model;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

import com.nilsson.utils.PrintColor;

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

    public double getDailyPrice(int days) {
        return dailyPrice * days;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public double calculateProfitPerRental(int rentalDays, Member member) {
        String membershipLevelValue = member.getMembershipLevel();
        double basePrice = getDailyPrice();
        double profitPerRental = basePrice * rentalDays;

        switch (membershipLevelValue) {
            case "Student":
                profitPerRental *= 0.8;
                break;
            case "Standard":
                profitPerRental *= 1.0;
                break;
            case "Premium":
                profitPerRental *= 1.2;
                break;
            default:
                PrintColor.red("Felaktig medlemsnivå: " + membershipLevelValue);
                break;
        }

        return profitPerRental;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
