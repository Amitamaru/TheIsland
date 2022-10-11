package com.javarush.marzhiievskyi.entity.animals.herbivorous;

import com.javarush.marzhiievskyi.entity.animals.Animal;
import com.javarush.marzhiievskyi.entity.animals.HerbivorousAnimals;
import com.javarush.marzhiievskyi.entity.animals.Plants;
import com.javarush.marzhiievskyi.entity.animals.plants.Grass;

public class Deer extends HerbivorousAnimals {


    protected Deer(String name, double weight, int MoveSpeed, double foodsNeeded) {
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
