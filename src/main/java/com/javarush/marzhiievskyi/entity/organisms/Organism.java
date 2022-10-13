package com.javarush.marzhiievskyi.entity.organisms;

public class Organism {
    private final String name;
    private double weight;
    private final int moveSpeed;
    private final double foodsNeeded;

    public Organism(String name, double weight, int moveSpeed, double foodsNeeded) {
        this.name = name;
        this.weight = weight;
        this.moveSpeed = moveSpeed;
        this.foodsNeeded = foodsNeeded;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return name;
    }
}
