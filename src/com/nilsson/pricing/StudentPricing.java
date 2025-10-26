package com.nilsson.pricing;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class StudentPricing implements PricePolicy {

    private final StandardPricing standardPricing;
    private final double STUDENT_DISCOUNT = 0.8;

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

    public StudentPricing(double dailyRate) {
        this.standardPricing = new StandardPricing(dailyRate);
    }

//── Getters & Setters ─────────────────────────────────────────────────────────────────────────────────────────────────

    @Override
    public double getMonthlyCost() {
        return standardPricing.getMonthlyCost() * STUDENT_DISCOUNT;
    }

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

@Override
    public double calculatePrice(int days) {
        return standardPricing.calculatePrice(days) * STUDENT_DISCOUNT;
}

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
