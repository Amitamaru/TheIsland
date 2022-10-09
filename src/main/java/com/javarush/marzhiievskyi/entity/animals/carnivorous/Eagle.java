package com.javarush.marzhiievskyi.entity.animals.carnivorous;

import com.javarush.marzhiievskyi.entity.animals.Animal;
import com.javarush.marzhiievskyi.entity.animals.CarnivorousAnimals;

public class Eagle extends CarnivorousAnimals {


    public Eagle(String name, double weight, int maxCountAnimalsOnCell, int maxMoveSpeed, double foodsNeeded) {
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
