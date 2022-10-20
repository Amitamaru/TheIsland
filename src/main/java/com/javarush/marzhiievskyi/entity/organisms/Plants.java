package com.javarush.marzhiievskyi.entity.organisms;

import com.javarush.marzhiievskyi.entity.field.Cell;
import com.javarush.marzhiievskyi.entity.organisms.actions.Reproductionable;

import java.util.Map;
import java.util.Set;

public abstract class Plants extends Organism implements Reproductionable {

    private final String name;
    private final String icon;
    private final double weight;
    private final int maxCountOnCell;

    private double currentWeight;

    public Plants(String name, String icon, double weight, int maxCountOnCell) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.maxCountOnCell = maxCountOnCell;
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

    }

    public void remove(Cell cell) {
        Map<Organism, Set<Organism>> mapOfAnimalsOnCell = cell.getMapOfAnimalsOnCell();
        for (var org : mapOfAnimalsOnCell.entrySet()) {
            if (((Plants) org.getKey()).getName().equalsIgnoreCase(this.name)) {
                org.getValue().remove(this);
            }
        }
        cell.setMapOfAnimalsOPnCell(mapOfAnimalsOnCell);
    }

    @Override
    public String toString() {
        return icon;
    }
}
