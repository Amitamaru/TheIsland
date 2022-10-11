package com.javarush.marzhiievskyi.entity.animals;


public abstract class CarnivorousAnimals extends Animal {


    protected CarnivorousAnimals(String name, double weight, int MoveSpeed, double foodsNeeded) {
        super(name, weight, MoveSpeed, foodsNeeded);
    }

    abstract public void eat(HerbivorousAnimals herbivorousAnimals);
    abstract public void move();
    abstract public Animal multiply(Animal animal);
}
