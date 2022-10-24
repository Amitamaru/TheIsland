package com.javarush.ua.marzhiievskyi.entity.organisms;

import com.javarush.ua.marzhiievskyi.entity.field.Cell;
import com.javarush.ua.marzhiievskyi.utils.Constants;


import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Plants extends Organism {

    private final String name;
    private final String icon;
    private final double weight;
    private final int maxCountOnCell;

    private double currentWeight;

    private final Organism currentType;

    public Plants(String name, String icon, double weight, int maxCountOnCell) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.maxCountOnCell = maxCountOnCell;
        this.currentWeight = weight;
        this.currentType = this;
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

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    @Override
    public void multiply(Cell cell) {

       cell.getLock().lock();
        try {//TODO check this (need to do like in animals)
            if (isNotDead()) {
                Set<Organism> organismSet = cell.getMapOfAnimalsOnCell().get(currentType);
                int chanceMultiply = ThreadLocalRandom.current().nextInt(0, 100);
                if ( chanceMultiply < Constants.CHANCE_TO_BIRTH_CHILD_FOR_PLANTS) {
                    for (int i = 0; i < Constants.COUNT_OF_DESCENDANTS_FOR_PLANTS; i++) {
                        if (organismSet.size() < this.maxCountOnCell) {
                            organismSet.add(this.clone());
                        }

                    }
                }

            } else {
                remove(cell);
            }


        } finally {
           cell.getLock().unlock();
        }
    }
    public boolean isNotDead() {
        return this.currentWeight != 0;
    }

    @Override
    public String toString() {
        return icon;
    }

    private void remove(Cell cell) {
        cell.getMapOfAnimalsOnCell().get(currentType).remove(this);
    }
}
