package com.nilsson.service;

import com.nilsson.policy.PremiumPricing;
import com.nilsson.policy.StandardPricing;
import com.nilsson.policy.StudentPricing;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class MembershipService {

    private StandardPricing standardPricing = new StandardPricing(1 * 1);
    private StudentPricing studentPricing = new StudentPricing(1 * 0.8);
    private PremiumPricing premiumPricing = new PremiumPricing(1 * 1.2);

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

    public double calculatePrice(int days, String strategyType) {
        switch (strategyType.toLowerCase()) {
            case "standard":
                return standardPricing.calculatePrice(days);
            case "student":
                return studentPricing.calculatePrice(days);
            case "premium":
                return premiumPricing.calculatePrice(days);
            default:
                throw new IllegalArgumentException("Ogiltlig medlemskapssnivå");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
