package com.nilsson.service;

//RentalService och MembershipService ska innehålla affärslogiken

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class RentalService implements PricePolicy{

    @Override
    public double calculatePrice(int days, String strategyType) {
        switch (strategyType.toLowerCase()) {
            case "standard":
                return PricePolicies.standardCalculatePrice(days);
            case "student":
                return PricePolicies.studentCalculatePrice(days);
            case "premium":
                return PricePolicies.premiumCalculatePrice(days);
            default:
                throw new IllegalArgumentException("Ogiltlig medlemskapssnivå");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
