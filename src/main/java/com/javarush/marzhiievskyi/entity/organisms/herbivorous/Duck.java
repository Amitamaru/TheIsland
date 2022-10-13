package com.javarush.marzhiievskyi.entity.organisms.herbivorous;

import com.javarush.marzhiievskyi.entity.organisms.Animal;
import com.javarush.marzhiievskyi.entity.organisms.HerbivorousAnimals;
import com.javarush.marzhiievskyi.entity.organisms.Plants;

public class Duck extends HerbivorousAnimals {


    public Duck(String name, double weight, int MoveSpeed, double foodsNeeded) {
        super(name, weight, MoveSpeed, foodsNeeded);
    }

    @Override
    public void eat(Plants plants) {

    }

    public void eat(Caterpillar caterpillar) {

    }

    @Override
    public void move() {

    }

    @Override
    public Animal multiply(Animal animal) {
        return null;
    }
}
