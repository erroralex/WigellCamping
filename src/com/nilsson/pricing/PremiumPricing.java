package com.nilsson.pricing;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class PremiumPricing implements PricePolicy {

    private final double PREMIUM_COST = 150;

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────
//── Getters & Setters ─────────────────────────────────────────────────────────────────────────────────────────────────

    @Override
    public double getMonthlyCost() {
        return PREMIUM_COST;
    }

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

    @Override
    public double calculatePrice(int days) {
        return PREMIUM_COST;
    }

}
