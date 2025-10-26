package com.nilsson.entity;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class RecreationalVehicle extends Vehicle {

    private int maxOccupants;

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

    public RecreationalVehicle() {

    }

    public RecreationalVehicle(double dailyPrice, boolean hasEngine, String color, int maxOccupants) {
        super(dailyPrice, hasEngine, color);
        this.maxOccupants = maxOccupants;
    }

//── Getters & Setters ─────────────────────────────────────────────────────────────────────────────────────────────────

    public int getMaxOccupants() {
        return maxOccupants;
    }

    public void setMaxOccupants(int maxOccupants) {
        this.maxOccupants = maxOccupants;
    }

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

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

