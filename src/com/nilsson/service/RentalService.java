package com.nilsson.service;

//RentalService och MembershipService ska innehålla affärslogiken
import com.nilsson.entity.*;
import com.nilsson.pricing.PricePolicy;
import com.nilsson.utils.PrintColor;

import java.util.HashMap;
import java.util.Map;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class RentalService implements PricePolicy {

    private Map<Item, Rental> rentedItems;
    MemberRegistry memberRegistry;

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

    public RentalService() {

    }

    public RentalService(MemberRegistry memberRegistry) {
        this.rentedItems = new HashMap<>();
        this.memberRegistry = memberRegistry;
    }

//── Getters & Setters ─────────────────────────────────────────────────────────────────────────────────────────────────

    public void setRentedItems(Map<Item, Rental> rentedItems) {
        this.rentedItems = rentedItems;
    }

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

    @Override
    public double calculatePrice(int days) {
        double totalRent = 0;
        for (Map.Entry<Item, Rental> entry : rentedItems.entrySet()) {
            Item item = entry.getKey();
            int rentalDays = entry.getValue().getDays();
            totalRent += item.getDailyPrice() * days;
        }
        return totalRent;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    @Override
    public double getMonthlyCost() {
        return 0;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    /**
     * FEL! Hittar inte rätt lista!
     * @return
     */
    public double calculateTotalProfit() {
        double totalProfit = 0.0;

        for (Map.Entry<Item, Rental> entry : rentedItems.entrySet()) {
            Item item = entry.getKey();
            int rentalDays = entry.getValue().getDays();

            // Assuming member is a variable that holds the current member's ID
            Member member = entry.getValue().getMember(); // Retrieve member from Rental object

            if (item instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) item;
                double basePrice = vehicle.getDailyPrice();

                String membershipLevelValue = member.getMembershipLevel();

                // Calculate profit based on rental days and membership level
                double profitPerRental = basePrice * rentalDays;
                switch (membershipLevelValue) {
                    case "Student":
                        profitPerRental *= 0.8;
                        break;
                    case "Standard":
                        profitPerRental *= 1.0;
                        break;
                    case "Premium":
                        profitPerRental *= 1.2;
                        break;
                    default:
                        PrintColor.red("Felaktig medlemsnivå: " + membershipLevelValue);
                        break;
                }

                totalProfit += profitPerRental;
            }
        }
        return totalProfit;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
