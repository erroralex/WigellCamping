package com.nilsson.policy;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class StandardPricing implements PricePolicy {

    private double dailyRate;

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

public StandardPricing() {

}

public StandardPricing(double dailyRate) {
    this.dailyRate = dailyRate;
}

//── Getters & Setters ─────────────────────────────────────────────────────────────────────────────────────────────────

    @Override
    public double getMonthlyCost() {
    return 30;
    }

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

    @Override
    public double calculatePrice(int days) {
        return days * dailyRate;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
