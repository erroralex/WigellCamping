package com.nilsson.service;

//RentalService och MembershipService ska innehålla affärslogiken
import com.nilsson.pricing.PremiumPricing;
import com.nilsson.pricing.StandardPricing;
import com.nilsson.pricing.StudentPricing;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class MembershipService {

    private StandardPricing standardPricing = new StandardPricing(10);
    private StudentPricing studentPricing = new StudentPricing(8);
    private PremiumPricing premiumPricing = new PremiumPricing();

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
