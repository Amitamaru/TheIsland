package com.javarush.marzhiievskyi.entity.organisms.carnivorous;


import com.javarush.marzhiievskyi.entity.organisms.Animal;
import com.javarush.marzhiievskyi.entity.organisms.CarnivorousAnimals;
import com.javarush.marzhiievskyi.entity.organisms.HerbivorousAnimals;

public class Woolf extends CarnivorousAnimals {


    protected Woolf(String name, double weight, int MoveSpeed, double foodsNeeded) {
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
