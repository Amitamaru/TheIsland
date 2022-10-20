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


    public Animals(String name, String icon, double maxWeight, int maxCountOnCell, int maxSpeed, double needFood) {
        this.name = name;
        this.icon = icon;
        this.maxWeight = maxWeight;
        this.maxCountOnCell = maxCountOnCell;
        this.maxSpeed = maxSpeed;
        this.needFood = needFood;
        this.currentWeight = maxWeight;
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
//        Animals animal = (Animals) organism;
//        //TODO get parameter that THIS.Organism can eat organism
//        if (isDead()) {
//            //our organism THIS is trying to eat organism from argument
//            double  weightOfOrganism = animal.getCurrentWeight();
//            double  currentWeight = this.getCurrentWeight() + weightOfOrganism;
//            this.setCurrentWeight(Math.min(currentWeight, this.getMaxWeight()));
//            ((Animals) organism).remove(cell);
//        } else {
//            this.remove(cell);
//        }
        // System.out.println(this.icon + " eat " + Thread.currentThread().getName());

        cell.getLock().lock();
        try {
            //System.out.println(this.icon + " Eat " + Thread.currentThread().getName() );

        } finally {
            cell.getLock().unlock();
        }
    }



    @Override
    public void move(Cell cell) {
        cell.getLock().lock();
        try {
            //System.out.println(this.icon + " Move " + Thread.currentThread().getName() );

        } finally {
            cell.getLock().unlock();
        }
    }

    @Override
    public void multiply(Cell cell) {
        cell.getLock().lock();
        try {
           // System.out.println(this.icon + " Multiply " + Thread.currentThread().getName() );

        } finally {
            cell.getLock().unlock();
        }
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
    public boolean isDead() {
        return !(this.currentWeight < (this.maxWeight - this.needFood));
    }
    //TODO make remove in gameWorker


    @Override
    public String toString() {
        return icon;
    }
}
