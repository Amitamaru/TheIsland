package com.javarush.marzhiievskyi.entity.animals;

public abstract class Plants {

    private final String name;
    private double weight;


    protected Plants(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    abstract public Plants multiply(Plants plants);
}
