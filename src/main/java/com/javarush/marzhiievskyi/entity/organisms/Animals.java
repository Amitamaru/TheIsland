package com.javarush.marzhiievskyi.entity.organisms;


import com.javarush.marzhiievskyi.entity.field.Cell;
import com.javarush.marzhiievskyi.entity.organisms.actions.Eatable;
import com.javarush.marzhiievskyi.entity.organisms.actions.Movable;
import com.javarush.marzhiievskyi.entity.organisms.actions.Reproductionable;
import com.javarush.marzhiievskyi.utils.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animals extends Organism implements Eatable, Movable {
    private final String name;
    private final String icon;
    private final double maxWeight;
    private final int maxCountOnCell;
    private final int maxSpeed;
    private final double needFood;
    private double currentWeight;

    private final Organism currentType;


    public Animals(String name, String icon, double maxWeight, int maxCountOnCell, int maxSpeed, double needFood) {
        this.name = name;
        this.icon = icon;
        this.maxWeight = maxWeight;
        this.maxCountOnCell = maxCountOnCell;
        this.maxSpeed = maxSpeed;
        this.needFood = needFood;
        this.currentWeight = maxWeight;
        this.currentType = this;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public double getMaxWeight() {
        return maxWeight;
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

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }


    @Override
    public void eat(Cell cell) {

        cell.getLock().lock();
        try {


        } finally {
            cell.getLock().unlock();
        }
    }



    @Override
    public void move(Cell cell) {
        cell.getLock().lock();
        try {

        } finally {
            cell.getLock().unlock();
        }
    }

    @Override
    public void multiply(Cell cell) {
        cell.getLock().lock();
        try {
            Set<Organism> organismSet = cell.getMapOfAnimalsOnCell().get(currentType);
            if (organismSet.size() > 1) {
                int chanceMultiply = ThreadLocalRandom.current().nextInt(0, 100);
                if (chanceMultiply < Constants.CHANCE_TO_BIRTH_CHILD) {
                    for (int i = 0; i < Constants.COUNT_OF_DESCENDANTS_FOR_ANIMALS; i++) {
                        if (organismSet.size() < this.maxCountOnCell) {
                            organismSet.add(this.clone());
                        }
                    }
                }
            }

        } finally {
            cell.getLock().unlock();
        }
    }
    public boolean isDead() {
        return !(this.currentWeight < (this.maxWeight - this.needFood));
    }
    //TODO make remove in gameWorker


    @Override
    public String toString() {
        return icon;
    }
}
