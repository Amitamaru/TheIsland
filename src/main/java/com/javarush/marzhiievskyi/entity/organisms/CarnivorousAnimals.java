package com.javarush.marzhiievskyi.entity.organisms;

import com.javarush.marzhiievskyi.entity.field.Cell;

public abstract class CarnivorousAnimals extends Animals {

    public CarnivorousAnimals(String name, String icon, double weight, int maxCountOnCell, int maxSpeed, double needFood) {
        super(name, icon, weight, maxCountOnCell, maxSpeed, needFood);
    }
    @Override
    public void eat(Organism organism, Cell currentCell) {
        Animals animal = (Animals) organism;
        //TODO get parameter that THIS.Organism can eat organism
        if (!isDead()) {
            //our organism THIS is trying to eat organism from argument
            double  weightOfOrganism = animal.getCurrentWeight();
            double  currentWeight = this.getCurrentWeight() + weightOfOrganism;
            this.setCurrentWeight(Math.min(currentWeight, this.getMaxWeight()));
            ((Animals) organism).remove(currentCell);
        } else {
            this.remove(currentCell);
        }


    }
}
