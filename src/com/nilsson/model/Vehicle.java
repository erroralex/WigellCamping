package com.nilsson.model;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class Vehicle extends Item {

    private boolean hasEngine;
    private String color;

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

    public Vehicle() {

    }

    public Vehicle(double dailyPrice, boolean hasEngine, String color) {
        super(dailyPrice);
        this.hasEngine = hasEngine;
        this.color = color;
    }

//── Getters & Setters ─────────────────────────────────────────────────────────────────────────────────────────────────

    public boolean isHasEngine() {
        return hasEngine;
    }

    public void setHasEngine(boolean hasEngine) {
        this.hasEngine = hasEngine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
