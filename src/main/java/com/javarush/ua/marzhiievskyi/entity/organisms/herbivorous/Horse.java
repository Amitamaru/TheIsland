package com.javarush.ua.marzhiievskyi.entity.organisms.herbivorous;

import com.javarush.ua.marzhiievskyi.entity.organisms.HerbivorousAnimals;

public class Horse extends HerbivorousAnimals {


    public Horse(String name, String icon, double weight, int maxCountOnCell, int maxSpeed, double needFood) {
        super(name, icon, weight, maxCountOnCell, maxSpeed, needFood);
    }


}
