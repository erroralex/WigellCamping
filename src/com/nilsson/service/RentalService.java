package com.nilsson.service;

//RentalService och MembershipService ska innehålla affärslogiken

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

import com.nilsson.pricing.PricePolicy;

public class RentalService implements PricePolicy {


    @Override
    public double calculatePrice(int days) {
        return 0;
    }

    @Override
    public double getMonthlyCost() {
        return 0;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
