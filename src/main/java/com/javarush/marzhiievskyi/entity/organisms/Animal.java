package com.javarush.marzhiievskyi.entity.organisms;


public abstract class Animal extends Organism {

    private final String name;
    private double weight;
    private final int moveSpeed;
    private final double foodsNeeded;

    protected Animal(String name, double weight, int moveSpeed, double foodsNeeded) {
        this.name = name;
        this.weight = weight;

        this.moveSpeed = moveSpeed;
        this.foodsNeeded = foodsNeeded;
    }

    @Override
    public String toString() {
        return name;
    }
}
