package com.nilsson.policy;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public interface PricePolicy {

    double calculatePrice(int days);
    double getMonthlyCost();

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
