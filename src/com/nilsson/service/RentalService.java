package com.nilsson.service;

import com.nilsson.model.*;
import com.nilsson.policy.PricePolicy;
import com.nilsson.repository.MemberRegistry;
import com.nilsson.utils.PrintColor;
import java.util.Map;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class RentalService implements PricePolicy {

    private Rental rental;
    private Map<Item, Rental> rentedItems;

    //MemberRegistry memberRegistry = MemberRegistry.getInstance();
    //MembershipService membershipService = new MembershipService();


//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

    public RentalService(Rental rental) {
        this.rental = rental;
        this.rentedItems = rental.getRentedItems();
    }

//── Getters & Setters ─────────────────────────────────────────────────────────────────────────────────────────────────



//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

    /*public double calculatePrice(int days) {
        double totalRent = 0;
        for (Map.Entry<Item, Rental> entry : rentedItems.entrySet()) {
            Item item = entry.getKey();
            int rentalDays = entry.getValue().getDays();
            totalRent += item.getDailyPrice() * days;
        }
        return totalRent;
    }*/

    public double calculatePrice(int days) {
        double totalRent = 0;
        for (Map.Entry<Item, Rental> entry : rentedItems.entrySet()) {
            Item item = entry.getKey();
            int rentalDays = entry.getValue().getDays();

            if (item == null || item.getDailyPrice() == 0) {
                System.out.println("Varning: Inget eller ogiltligt pris på föremål: " + item);
                continue;
            }

            double dailyPrice = item.getDailyPrice();
            double rentForThisItem = dailyPrice * rentalDays;

            totalRent += rentForThisItem;
        }

        return totalRent;
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

            if (item instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) item;
                double basePrice = vehicle.getDailyPrice();

                String membershipLevelValue = member.getMembershipLevel();
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
