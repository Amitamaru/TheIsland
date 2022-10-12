package com.javarush.marzhiievskyi.entity.organisms;

public abstract class Plants extends Organism {

    private final String name;
    private double weight;


    protected Plants(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    abstract public Plants multiply(Plants plants);
}
