package com.javarush.marzhiievskyi.entity.organisms;


public abstract class CarnivorousAnimals extends Animal {


    public CarnivorousAnimals(String name, double weight, int MoveSpeed, double foodsNeeded) {
        super(name, weight, MoveSpeed, foodsNeeded);
    }

    abstract public void eat(HerbivorousAnimals herbivorousAnimals);
    abstract public void move();
    abstract public Animal multiply(Animal animal);
}
