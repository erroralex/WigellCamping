package com.nilsson.entity;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class Vehicle extends Item {

    private boolean hasEngine;
    private String color;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public Vehicle() {

    }

    public Vehicle(boolean hasEngine, String color) {
    this.hasEngine = hasEngine;
    this.color = color;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

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
