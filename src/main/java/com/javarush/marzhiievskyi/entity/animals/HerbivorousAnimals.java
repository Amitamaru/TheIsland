package com.javarush.marzhiievskyi.entity.animals;


import com.javarush.marzhiievskyi.entity.animals.plants.Grass;

public abstract class HerbivorousAnimals extends Animal {


    public HerbivorousAnimals(String name, double weight, int maxCountAnimalsOnCell, int maxMoveSpeed, double foodsNeeded) {
        super(name, weight, maxCountAnimalsOnCell, maxMoveSpeed, foodsNeeded);
    }
}
