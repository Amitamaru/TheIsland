package com.javarush.marzhiievskyi.entity.animals;


public abstract class Animal {

    private String name;
    private double weight;
    private int maxCountAnimalsOnCell;
    private int maxMoveSpeed;
    private double foodsNeeded;

    public Animal(String name, double weight, int maxCountAnimalsOnCell, int maxMoveSpeed, double foodsNeeded) {
        this.name = name;
        this.weight = weight;
        this.maxCountAnimalsOnCell = maxCountAnimalsOnCell;
        this.maxMoveSpeed = maxMoveSpeed;
        this.foodsNeeded = foodsNeeded;
    }

    public abstract void eat();
    public abstract void move();
    public abstract void multiply();

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxCountAnimalsOnCell() {
        return maxCountAnimalsOnCell;
    }

    public int getMaxMoveSpeed() {
        return maxMoveSpeed;
    }

    public double getFoodsNeeded() {
        return foodsNeeded;
    }


}
