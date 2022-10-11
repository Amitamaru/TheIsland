package com.javarush.marzhiievskyi.entity.animals.carnivorous;


import com.javarush.marzhiievskyi.entity.animals.Animal;
import com.javarush.marzhiievskyi.entity.animals.CarnivorousAnimals;
import com.javarush.marzhiievskyi.entity.animals.HerbivorousAnimals;

public class Fox extends CarnivorousAnimals {


    protected Fox(String name, double weight, int MoveSpeed, double foodsNeeded) {
        super(name, weight, MoveSpeed, foodsNeeded);
    }

    @Override
    public void eat(HerbivorousAnimals herbivorousAnimals) {

    }

    @Override
    public void move() {

    }

    @Override
    public Animal multiply(Animal animal) {
        return null;
    }
}
