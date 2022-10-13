package com.javarush.marzhiievskyi.entity.organisms.plants;

import com.javarush.marzhiievskyi.entity.organisms.Plants;

public class Grass extends Plants {


    public Grass(String name, double weight, int moveSpeed, double foodsNeeded) {
        super(name, weight, moveSpeed, foodsNeeded);
    }

    @Override
    public Plants multiply(Plants plants) {
        return null;
    }
}
