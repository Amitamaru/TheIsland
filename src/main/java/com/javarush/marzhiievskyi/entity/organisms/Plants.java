package com.javarush.marzhiievskyi.entity.organisms;

public abstract class Plants extends Organism {


    public Plants(String name, double weight, int moveSpeed, double foodsNeeded) {
        super(name, weight, moveSpeed, foodsNeeded);
    }

    abstract public Plants multiply(Plants plants);
}
