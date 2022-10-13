package com.javarush.marzhiievskyi.entity.organisms.herbivorous;

import com.javarush.marzhiievskyi.entity.organisms.Animal;
import com.javarush.marzhiievskyi.entity.organisms.HerbivorousAnimals;
import com.javarush.marzhiievskyi.entity.organisms.Plants;

public class Goat extends HerbivorousAnimals {


    public  Goat(String name, double weight, int MoveSpeed, double foodsNeeded) {
        super(name, weight, MoveSpeed, foodsNeeded);
    }

    @Override
    public void eat(Plants plants) {

    }

    @Override
    public void move() {

    }

    @Override
    public Animal multiply(Animal animal) {
        return null;
    }
}
