package com.nilsson.service;

import com.nilsson.model.*;
import com.nilsson.policy.PricePolicy;
import java.util.Map;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class RentalService implements PricePolicy {

    private Rental rental;
    private Map<Item, Rental> rentedItems;

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

    public RentalService(Rental rental) {
        this.rental = rental;
        this.rentedItems = rental.getRentedItems();
    }

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

    public double calculatePrice(int days) {
       return 0;
    }

    public double calculatePrice(Item item, int days, Member member) {
        if (item == null || item.getDailyPrice() <= 0) {
            System.out.println("Varning: Inget föremål eller felaktigt pris: " + item);
            return 0;
        }
        return item.calculateProfitPerRental(days, member);
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    @Override
    public double getMonthlyCost() {
        return 0;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public double calculateTotalProfit() {
        double totalProfit = 0.0;

        for (Map.Entry<Item, Rental> entry : rentedItems.entrySet()) {
            Item item = entry.getKey();
            Member member = entry.getValue().getMember();
            int rentalDays = entry.getValue().getDays();

            double profitPerRental = item.calculateProfitPerRental(rentalDays, member);
            totalProfit += profitPerRental;
        }

        return totalProfit;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
