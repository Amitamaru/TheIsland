package com.javarush.marzhiievskyi.entity.animals.plants;

import com.javarush.marzhiievskyi.entity.animals.Plants;

public class Grass extends Plants {


    protected Grass(String name, double weight) {
        super(name, weight);
    }

    @Override
    public Plants multiply(Plants plants) {
        return null;
    }
}
