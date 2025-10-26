package com.nilsson.pricing;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public interface PricePolicy {

    /**
     * Calculates the price based on the number of days.
     *
     * @param days The number of days for which the price is calculated.
     * @return The total price.
     */
    double calculatePrice(int days);

    /**
     * Retrieves the monthly cost.
     *
     * @return The monthly cost.
     */
    double getMonthlyCost();

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
