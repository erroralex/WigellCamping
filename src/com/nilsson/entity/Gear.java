package com.nilsson.entity;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class Gear extends Item {

    private int maxOccupants;

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

    public Gear(double dailyPrice, int maxOccupants) {
        super(dailyPrice);
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
        sb.append("Utrustning: ");

        if (maxOccupants > 0) {
            sb.append("Tält, ").append(getMaxOccupants()).append(" personer, ");
        } else {
            sb.append("Ryggsäck, ");
        }

        sb.append("Grundpris: ").append(getDailyPrice())
                .append(":- per dygn");

        return sb.toString();
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
