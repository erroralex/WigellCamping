package com.nilsson.service;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public interface PricePolicy {

    double calculatePrice(int days, String strategyType);

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public class PricePolicies {

        public static double studentCalculatePrice(int days) {
            return 1.3 * days;
        }

        public static double standardCalculatePrice(int days) {
            return 1.5 * days;
        }

        public static double premiumCalculatePrice(int days) {
            return 2 * days;
        }
    }
}
