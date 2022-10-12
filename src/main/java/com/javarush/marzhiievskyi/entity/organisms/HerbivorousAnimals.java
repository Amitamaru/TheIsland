package com.javarush.marzhiievskyi.entity.organisms;


public abstract class HerbivorousAnimals extends Animal {

    protected HerbivorousAnimals(String name, double weight, int MoveSpeed, double foodsNeeded) {
        super(name, weight, MoveSpeed, foodsNeeded);
    }

    abstract public void eat(Plants plants);
    abstract public void move();
    abstract public Animal multiply(Animal animal);
}
