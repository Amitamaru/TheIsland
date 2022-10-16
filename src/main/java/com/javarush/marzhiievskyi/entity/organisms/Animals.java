package com.javarush.marzhiievskyi.entity.organisms;


import com.javarush.marzhiievskyi.entity.organisms.actions.Eatable;
import com.javarush.marzhiievskyi.entity.organisms.actions.Movable;
import com.javarush.marzhiievskyi.entity.organisms.actions.Reproductionable;

public abstract class Animals extends Organism implements Eatable, Movable, Reproductionable {
    private final String name;
    private final String icon;
    private final double weight;
    private final int maxCountOnCell;
    private final int maxSpeed;
    private final double needFood;


    public Animals(String name, String icon, double weight, int maxCountOnCell, int maxSpeed, double needFood) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.maxCountOnCell = maxCountOnCell;
        this.maxSpeed = maxSpeed;
        this.needFood = needFood;
    }

    @Override
    public String toString() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxCountOnCell() {
        return maxCountOnCell;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getNeedFood() {
        return needFood;
    }
}
