package com.nilsson.entity;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class RecreationalVehicle extends Vehicle {

    private int maxOccupants;
    private double price;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public RecreationalVehicle() {

    }

    public RecreationalVehicle(boolean hasEngine, String color, int maxOccupants, double price) {
        super(hasEngine, color);
        this.maxOccupants = maxOccupants;
        this.price = price;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public int getMaxOccupants() {
        return maxOccupants;
    }

    public void setMaxOccupants(int maxOccupants) {
        this.maxOccupants = maxOccupants;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}

