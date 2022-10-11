package com.javarush.marzhiievskyi.entity.animals;


import com.javarush.marzhiievskyi.entity.animals.plants.Grass;

public abstract class HerbivorousAnimals extends Animal {

    protected HerbivorousAnimals(String name, double weight, int MoveSpeed, double foodsNeeded) {
        super(name, weight, MoveSpeed, foodsNeeded);
    }

    abstract public void eat(Plants plants);
    abstract public void move();
    abstract public Animal multiply(Animal animal);
}
