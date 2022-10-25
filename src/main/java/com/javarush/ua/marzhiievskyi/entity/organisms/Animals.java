package com.javarush.ua.marzhiievskyi.entity.organisms;


import com.javarush.ua.marzhiievskyi.entity.field.Cell;
import com.javarush.ua.marzhiievskyi.entity.organisms.actions.Eatable;
import com.javarush.ua.marzhiievskyi.entity.organisms.actions.Movable;
import com.javarush.ua.marzhiievskyi.utils.Constants;
import com.javarush.ua.marzhiievskyi.utils.ParametersForEating;
import com.javarush.ua.marzhiievskyi.utils.gettingParameters.GettingParametersOfEating;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

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
            if (isNotDead()) {
                weightLose();

                List<GettingParametersOfEating.AnimalsEatable> eatParameters = ParametersForEating.getParametersForEating().getEatParameters(this);

                int magicRandomToEat = ThreadLocalRandom.current().nextInt(0, 100);                         // chance to eat
                int magicRandomWhatAnimalToEat = ThreadLocalRandom.current().nextInt(0, eatParameters.size());     // selecting type of organism to eat

                if (this instanceof HerbivorousAnimals) {
                    magicRandomWhatAnimalToEat = eatParameters.indexOf(eatParameters.get(eatParameters.size() - 1));
                }
                String name = eatParameters.get(magicRandomWhatAnimalToEat).getName();


                if (magicRandomToEat < eatParameters.get(magicRandomWhatAnimalToEat).getChanceToEat()
                        && checkThatAnimalIsInCell(cell, name)
                        && this.getCurrentWeight() < this.getMaxWeight()) {
                    cell.getMapOfAnimalsOnCell().forEach((key, value) -> {
                        if (name.equalsIgnoreCase(key.getClass().getSimpleName())) {
                            Organism organism = value.iterator().next();
                            if (organism instanceof Animals animals) {
                                this.setCurrentWeight(Math.min((animals.getCurrentWeight() + this.getCurrentWeight()), this.getMaxWeight()));
                                animals.setCurrentWeight(0);
                            } else if (organism instanceof Plants plants) {
                                this.setCurrentWeight(Math.min((plants.getCurrentWeight() + this.getCurrentWeight()), this.getMaxWeight()));
                                plants.setCurrentWeight(0);
                            }
                        }
                    });
                }
            }
        } finally {
            cell.getLock().unlock();
        }
    }

    private boolean checkThatAnimalIsInCell(Cell cell, String name) {

        AtomicBoolean result = new AtomicBoolean(false);
        Map<Organism, Set<Organism>> mapOfAnimalsOnCell = cell.getMapOfAnimalsOnCell();
        mapOfAnimalsOnCell.forEach((key, value) -> {
            if (key.getClass().getSimpleName().toLowerCase().equals(name)) {
                if (value.size() != 0) {
                    result.set(true);
                }
            }
        });
        return result.get();
    }

    @Override
    public void move(Cell cell) {
        cell.getLock().lock();
        try {
            if (isNotDead()) {
                weightLose();
                if (ThreadLocalRandom.current().nextBoolean() && this.maxSpeed != 0) {
                    moveOnOneCell(cell);
                }
            } else {
                remove(cell);
            }
        } finally {
            cell.getLock().unlock();
        }
    }

    private void moveOnOneCell(Cell cell) {
            int speed = this.maxSpeed;
            Cell destinationCell = getTargetCell(cell);
            while (speed > 1) {
                destinationCell = getTargetCell(destinationCell);
                speed--;
            }
            if (destinationCell.getMapOfAnimalsOnCell().get(currentType).size() < this.maxCountOnCell) {
                destinationCell.getMapOfAnimalsOnCell().get(currentType).add(this.clone());
                cell.getMapOfAnimalsOnCell().get(currentType).remove(this);
            }
    }

    private Cell getTargetCell(Cell cell) {
            List<Cell> roadToMove = cell.generateMoveList(cell);
            int chosenRoad = ThreadLocalRandom.current().nextInt(0, roadToMove.size());
            return roadToMove.get(chosenRoad);
    }

    private void weightLose() {
        this.currentWeight = this.currentWeight - (this.currentWeight * Constants.WEIGHT_LOSE_PER_ACTION) / 100;
    }

    @Override
    public void multiply(Cell cell) {
        cell.getLock().lock();
        try {
            if (isNotDead()) {
                weightLose();
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
            } else {
                remove(cell);
            }
        } finally {
            cell.getLock().unlock();
        }
    }

    private void remove(Cell cell) {
            cell.getMapOfAnimalsOnCell().get(currentType).remove(this);
    }

    public boolean isNotDead() {
        return (!(this.currentWeight < (this.maxWeight - this.needFood)));
    }

    @Override
    public String toString() {
        return this.icon;
    }
}
