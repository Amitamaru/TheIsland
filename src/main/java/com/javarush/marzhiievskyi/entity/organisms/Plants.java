package com.javarush.marzhiievskyi.entity.organisms;

import com.javarush.marzhiievskyi.entity.field.Cell;
import com.javarush.marzhiievskyi.entity.organisms.actions.Reproductionable;
import com.javarush.marzhiievskyi.entity.organisms.plants.Grass;
import com.javarush.marzhiievskyi.utils.Constants;

import java.util.HashMap;
import java.util.HashSet;
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

    //Do we really need setter on weight?
    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }


    @Override
    public void multiply(Cell cell) {

       cell.getLock().lock();
        try {
            Set<Organism> organismSet = cell.getMapOfAnimalsOnCell().get(currentType);
            int chanceMultiply = ThreadLocalRandom.current().nextInt(0, 100);
            if (organismSet.size() < this.getMaxCountOnCell() && chanceMultiply < Constants.CHANCE_TO_BIRTH_CHILD) {
                for (int i = 0; i < Constants.COUNT_OF_DESCENDANTS_FOR_PLANTS; i++) {
                    organismSet.add(this.clone());
                }
            }
            Map<Organism, Set<Organism>> mapOfAnimalsOnCell = cell.getMapOfAnimalsOnCell();
            mapOfAnimalsOnCell.put(currentType, organismSet);

        } finally {
           cell.getLock().unlock();
        }
    }


    @Override
    public String toString() {
        return icon;
    }
}
