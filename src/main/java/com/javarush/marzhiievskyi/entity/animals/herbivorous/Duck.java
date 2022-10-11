package com.javarush.marzhiievskyi.entity.animals.herbivorous;

import com.javarush.marzhiievskyi.entity.animals.Animal;
import com.javarush.marzhiievskyi.entity.animals.HerbivorousAnimals;
import com.javarush.marzhiievskyi.entity.animals.Plants;
import com.javarush.marzhiievskyi.entity.animals.plants.Grass;

public class Duck extends HerbivorousAnimals {


    protected Duck(String name, double weight, int MoveSpeed, double foodsNeeded) {
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
