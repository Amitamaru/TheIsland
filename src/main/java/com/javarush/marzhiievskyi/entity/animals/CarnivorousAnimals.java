package com.javarush.marzhiievskyi.entity.animals;


public abstract class CarnivorousAnimals extends Animal {

    public CarnivorousAnimals(String name, double weight, int maxCountAnimalsOnCell, int maxMoveSpeed, double foodsNeeded) {
        super(name, weight, maxCountAnimalsOnCell, maxMoveSpeed, foodsNeeded);
    }


}
