package com.javarush.marzhiievskyi.entity.animals.herbivorous;

import com.javarush.marzhiievskyi.entity.animals.Animal;
import com.javarush.marzhiievskyi.entity.animals.HerbivorousAnimals;
import com.javarush.marzhiievskyi.entity.animals.plants.Grass;

public class Horse extends HerbivorousAnimals {


    public Horse(String name, double weight, int maxCountAnimalsOnCell, int maxMoveSpeed, double foodsNeeded) {
        super(name, weight, maxCountAnimalsOnCell, maxMoveSpeed, foodsNeeded);
    }

    @Override
    public void eat() {

    }

    @Override
    public void move() {

    }

    @Override
    public void multiply() {

    }
}
