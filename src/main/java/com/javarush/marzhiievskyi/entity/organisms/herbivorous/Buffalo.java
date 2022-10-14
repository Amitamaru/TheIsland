package com.javarush.marzhiievskyi.entity.organisms.herbivorous;

import com.javarush.marzhiievskyi.entity.organisms.HerbivorousAnimals;

public class Buffalo extends HerbivorousAnimals {


    public Buffalo(String name, String icon, double weight, int maxCountOnCell, int maxSpeed, double needFood) {
        super(name, icon, weight, maxCountOnCell, maxSpeed, needFood);
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
