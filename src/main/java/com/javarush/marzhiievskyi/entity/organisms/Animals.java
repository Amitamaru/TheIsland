package com.javarush.marzhiievskyi.entity.organisms;


import com.javarush.marzhiievskyi.entity.field.Cell;
import com.javarush.marzhiievskyi.entity.organisms.actions.Eatable;
import com.javarush.marzhiievskyi.entity.organisms.actions.Movable;
import com.javarush.marzhiievskyi.entity.organisms.actions.Reproductionable;

import java.util.Map;
import java.util.Set;

public abstract class Animals extends Organism implements Eatable, Movable, Reproductionable {
    private final String name;
    private final String icon;
    private final double maxWeight;
    private final int maxCountOnCell;
    private final int maxSpeed;
    private final double needFood;
    private double currentWeight;


    public Animals(String name, String icon, double maxWeight, int maxCountOnCell, int maxSpeed, double needFood) {
        this.name = name;
        this.icon = icon;
        this.maxWeight = maxWeight;
        this.maxCountOnCell = maxCountOnCell;
        this.maxSpeed = maxSpeed;
        this.needFood = needFood;
        this.currentWeight = maxWeight;
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
    public void move() {
        this.currentWeight = currentWeight - 5;

    }

    @Override
    public void multiply() {

    }

    public boolean isDead() {
        return this.currentWeight < (this.maxWeight - this.needFood);
    }

    public void remove(Cell cell) {
        Map<Organism, Set<Organism>> mapOfAnimalsOnCell = cell.getMapOfAnimalsOnCell();
        for (var org : mapOfAnimalsOnCell.entrySet()) {
            if (((Animals) org.getKey()).getName().equalsIgnoreCase(this.name)) {
                org.getValue().remove(this);
            }
        }
        cell.setMapOfAnimalsOPnCell(mapOfAnimalsOnCell);
    }
}
