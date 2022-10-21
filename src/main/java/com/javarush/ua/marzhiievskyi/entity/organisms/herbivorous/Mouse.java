package com.javarush.ua.marzhiievskyi.entity.organisms.herbivorous;

import com.javarush.ua.marzhiievskyi.entity.organisms.HerbivorousAnimals;

public class Mouse extends HerbivorousAnimals {


    public Mouse(String name, String icon, double weight, int maxCountOnCell, int maxSpeed, double needFood) {
        super(name, icon, weight, maxCountOnCell, maxSpeed, needFood);
    }


}
