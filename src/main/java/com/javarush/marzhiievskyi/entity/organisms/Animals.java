package com.javarush.marzhiievskyi.entity.organisms;


import com.javarush.marzhiievskyi.entity.field.Cell;
import com.javarush.marzhiievskyi.entity.field.GameField;
import com.javarush.marzhiievskyi.entity.organisms.actions.Eatable;
import com.javarush.marzhiievskyi.entity.organisms.actions.Movable;
import com.javarush.marzhiievskyi.entity.organisms.actions.Reproductionable;

import java.util.Map;
import java.util.Set;

public abstract class Animals extends Organism implements Eatable, Movable, Reproductionable {
    private final String name;
    private final String icon;
    private final double weight;
    private final int maxCountOnCell;
    private final int maxSpeed;
    private final double needFood;
    private double currentWeight;


    public Animals(String name, String icon, double weight, int maxCountOnCell, int maxSpeed, double needFood) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.maxCountOnCell = maxCountOnCell;
        this.maxSpeed = maxSpeed;
        this.needFood = needFood;
        this.currentWeight = weight;
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

    @Override
    public void eat(Organism organism) {
//       // Cell currentCell = GameField;//TODO get current cell from GameField HOW? =/
//
//        //TODO get parameter that THIS.Organism can eat organism
//        if (!isDead()) {
//            //TODO do processing eating
//        } else {
//            this.remove(currentCell);
//        }


    }


    @Override
    public void move() {
        this.currentWeight = currentWeight - 5;

    }

    @Override
    public void multiply() {

    }

    private boolean isDead() {
        return this.currentWeight < (this.weight - this.needFood);
    }

    private void remove(Cell cell) {
        Map<Organism, Set<Organism>> mapOfAnimalsOnCell = cell.getMapOfAnimalsOnCell();
        for (var org : mapOfAnimalsOnCell.entrySet()) {
            if (( (Animals) org.getKey()).getName().equalsIgnoreCase(this.name)) {
                org.getValue().remove(this);
            }
        }
        cell.setMapOfAnimalsOPnCell(mapOfAnimalsOnCell);
    }
}
