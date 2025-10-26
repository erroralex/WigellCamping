package com.nilsson.entity;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class Gear extends Item {

    private int maxOccupants;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public Gear(double price, int maxOccupants) {
        super(price);
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
