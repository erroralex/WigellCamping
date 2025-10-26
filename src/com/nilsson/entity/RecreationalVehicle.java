package com.nilsson.entity;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class RecreationalVehicle extends Vehicle {

    private int maxOccupants;
    private double price;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public RecreationalVehicle() {

    }

    public RecreationalVehicle(double price, boolean hasEngine, String color, int maxOccupants) {
        super(price, hasEngine, color);
        this.maxOccupants = maxOccupants;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public int getMaxOccupants() {
        return maxOccupants;
    }

    public void setMaxOccupants(int maxOccupants) {
        this.maxOccupants = maxOccupants;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fordon: ");

        if (isHasEngine()) {
            sb.append("Husbil, ");
        } else {
            sb.append("Husvagn, ");
        }

        sb.append(maxOccupants).append(" passagerare")
                .append(", färg '").append(getColor()).append("'")
                .append(", Grundpris: ").append(getDailyPrice())
                .append(":- per dygn");

        return sb.toString();
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}

