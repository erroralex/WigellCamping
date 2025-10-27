package com.nilsson.policy;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class PremiumPricing implements PricePolicy {

    private final StandardPricing standardPricing;
    private final double PREMIUM_RATE = 1.2;

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

    public PremiumPricing(double dailyRate) {
        this.standardPricing = new StandardPricing(dailyRate);
    }

//── Getters & Setters ─────────────────────────────────────────────────────────────────────────────────────────────────

    @Override
    public double getMonthlyCost() {
        return standardPricing.getMonthlyCost() * PREMIUM_RATE;
    }

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

    @Override
    public double calculatePrice(int days) {
        return standardPricing.calculatePrice(days) * PREMIUM_RATE;
    }

}
