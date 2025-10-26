package com.nilsson.pricing;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public interface PricePolicy {

    double calculatePrice(int days);
    double getMonthlyCost();

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
